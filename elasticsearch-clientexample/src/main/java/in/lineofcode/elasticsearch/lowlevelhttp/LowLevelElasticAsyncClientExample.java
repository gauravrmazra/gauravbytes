package in.lineofcode.elasticsearch.lowlevelhttp;

import static in.lineofcode.elasticsearch.lowlevelhttp.LowlevelHttpClientUtils.createSimpleClient;
import static in.lineofcode.elasticsearch.lowlevelhttp.LowlevelHttpClientUtils.getJSONObjectFromResponse;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.StatusLine;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;

public class LowLevelElasticAsyncClientExample {
	private static final Logger LOG = Logger.getLogger("LowLevelElasticAsyncLogger");
	
	public static void main(String[] args) {
		try (RestClient client = createSimpleClient()) {
			final CountDownLatch latch = new CountDownLatch(1);
			client.performRequestAsync("GET", "/", new AsyncResponseListener(latch));
			latch.await();
			
		} catch (IOException | InterruptedException io) {
			LOG.log(Level.SEVERE, "Exception occcurred", io);
		}
	}
	
	static class AsyncResponseListener implements ResponseListener {
		
		private final CountDownLatch latch;

		public AsyncResponseListener(final CountDownLatch latch) {
			this.latch = latch;
		}
		
		@Override
		public void onFailure(Exception exception) {
			LOG.log(Level.WARNING, "Exception occurred while getting response", exception);
			latch.countDown();
		}

		@Override
		public void onSuccess(Response response) {
			try {
				StatusLine statusLine = response.getStatusLine();
				if (statusLine.getStatusCode() == 200) {
					try {
						JSONObject obj = getJSONObjectFromResponse(response);
						LOG.info(() -> obj.toString(2));
					} catch (IOException io) {
						LOG.warning("Not able to parse payload from response");
					}

				} else {
					LOG.warning("Invalid response");
				}				
			}
			finally {
				latch.countDown();
			}
		}
	}
}
