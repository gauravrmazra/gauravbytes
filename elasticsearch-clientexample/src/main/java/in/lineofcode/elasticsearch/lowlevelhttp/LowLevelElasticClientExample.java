package in.lineofcode.elasticsearch.lowlevelhttp;

import static in.lineofcode.elasticsearch.lowlevelhttp.LowlevelHttpClientUtils.createSimpleClient;
import static in.lineofcode.elasticsearch.lowlevelhttp.LowlevelHttpClientUtils.getJSONObjectFromResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.StatusLine;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://lineofcode.in}
 *         {@link https://gauravbytes.com}
 *
 */
public class LowLevelElasticClientExample {
	private static final Logger LOG = Logger.getLogger("LowLevelElasticClientExample");
	public static void main(String[] args) {
		try (RestClient client = createSimpleClient()) {
			Response response = client.performRequest("GET", "/");
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == 200) {
				JSONObject obj = getJSONObjectFromResponse(response);
				LOG.info(() -> obj.toString(2));

			} else {
				LOG.warning("Invalid response");
			}
		} catch (IOException io) {
			LOG.log(Level.SEVERE, "Exception occurred", io);
		}
	}
}
