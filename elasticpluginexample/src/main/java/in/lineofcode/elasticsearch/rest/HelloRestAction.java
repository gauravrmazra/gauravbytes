package in.lineofcode.elasticsearch.rest;

import java.io.IOException;

import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;
import org.elasticsearch.rest.RestRequest.Method;
import org.elasticsearch.rest.RestStatus;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class HelloRestAction extends BaseRestHandler {

	public HelloRestAction(Settings settings, RestController restController) {
		super(settings);
		restController.registerHandler(Method.GET, "/_hello", this);
	}

	@Override
	public String getName() {
		return "HelloRestAction";
	}

	@Override
	protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
		String clusterName = client.settings().get("cluster.name");

		return channel -> channel.sendResponse(new BytesRestResponse(RestStatus.OK, XContentFactory.jsonBuilder()
				.startObject().field("hello", "Hello from cluster: " + clusterName).endObject()));
	}

}
