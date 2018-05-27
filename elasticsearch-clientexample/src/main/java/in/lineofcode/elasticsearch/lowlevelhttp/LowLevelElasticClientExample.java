package in.lineofcode.elasticsearch.lowlevelhttp;

import static in.lineofcode.elasticsearch.lowlevelhttp.LowlevelHttpClientUtils.createSimpleClient;
import static in.lineofcode.elasticsearch.lowlevelhttp.LowlevelHttpClientUtils.getJSONObjectFromResponse;

import java.io.IOException;

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

	public static void main(String[] args) {
		try (RestClient client = createSimpleClient()) {
			Response response = client.performRequest("GET", "/");
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == 200) {
				JSONObject obj = getJSONObjectFromResponse(response);
				System.out.println(obj.toString(2));

			} else {
				System.err.println("Invalid response");
			}
		} catch (IOException io) {
			System.err.println(io);
		}
	}
}
