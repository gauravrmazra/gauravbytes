package in.lineofcode.elasticsearch;

import static org.hamcrest.Matchers.is;

import java.util.Collection;
import java.util.Collections;

import org.elasticsearch.action.admin.cluster.node.info.NodeInfo;
import org.elasticsearch.action.admin.cluster.node.info.NodesInfoResponse;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.PluginInfo;
import org.elasticsearch.test.ESIntegTestCase;
import org.junit.Test;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class ElasticSearchDemoPluginIntegrationTest extends ESIntegTestCase {
	@Override
	protected Collection<Class<? extends Plugin>> nodePlugins() {
		return Collections.singleton(ElasticSearchDemoPlugin.class);
	}

	@Test
	public void testPluginIsLoaded() {
		NodesInfoResponse response = client().admin().cluster().prepareNodesInfo().setPlugins(true).get();

		for (NodeInfo nodeInfo : response.getNodes()) {
			boolean pluginFound = false;
			for (PluginInfo pluginInfo : nodeInfo.getPlugins().getPluginInfos()) {
				if (pluginInfo.getName().equals(ElasticSearchDemoPlugin.class.getName())) {
					pluginFound = true;
					break;
				}
			}
			assertThat(pluginFound, is(true));
		}
	}
}
