package in.lineofcode.elasticsearch.lowlevelhttp;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClient.FailureListener;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.elasticsearch.client.RestClientBuilder;

/**
 * Utility class to build clients
 * @author Gaurav Rai Mazra
 *
 */
public class LowlevelHttpClientUtils {
	private LowlevelHttpClientUtils() {

	}
	
	public static RestClient createSimpleClient() {
		return RestClient.builder(new HttpHost("localhost", 9200, "http")).build();
	}
	
	public static RestClient createClientWithDefaultHeaders() {
		RestClientBuilder clientBuilder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
		
		Header[] defaultHeaders = new Header[2];
		defaultHeaders[0] = new BasicHeader("COMPANY", "GAURAVBYTES");
		defaultHeaders[1] = new BasicHeader("OWNER", "Gaurav Rai Mazra");
		
		clientBuilder.setDefaultHeaders(defaultHeaders);
		clientBuilder.setFailureListener(failureListener());
		return clientBuilder.build();
	}

	private static FailureListener failureListener() {
		return new FailureListener() {
			@Override
			public void onFailure(HttpHost host) {
				System.out.println(String.format("Not able to connect to elastic host: %s://%s:%d",
						host.getSchemeName(), host.getHostName(), host.getPort()));
			}
		};
	}
	
	public static JSONObject getJSONObjectFromResponse(Response response) throws IOException {
		try (InputStream in = response.getEntity().getContent())
		{
			JSONTokener tokener = new JSONTokener(in);
			return new JSONObject(tokener);
		}
	}
}
