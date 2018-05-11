package in.lineofcode.elasticsearch;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import org.elasticsearch.cluster.metadata.IndexNameExpressionResolver;
import org.elasticsearch.cluster.node.DiscoveryNodes;
import org.elasticsearch.common.settings.ClusterSettings;
import org.elasticsearch.common.settings.IndexScopedSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.SettingsFilter;
import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestHandler;

import in.lineofcode.elasticsearch.rest.HelloRestAction;

/**
 * ElasticSearch Demo Plugin
 * @author Gaurav Rai Mazra
 *
 */
public class ElasticSearchDemoPlugin extends Plugin implements ActionPlugin {
	@Override
	public List<RestHandler> getRestHandlers(Settings settings, RestController restController,
			ClusterSettings clusterSettings, IndexScopedSettings indexScopedSettings, SettingsFilter settingsFilter,
			IndexNameExpressionResolver indexNameExpressionResolver, Supplier<DiscoveryNodes> nodesInCluster) {
		return Collections.singletonList(new HelloRestAction(settings, restController));
	}
}
