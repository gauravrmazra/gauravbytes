package in.lineofcode.elasticsearch;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import org.elasticsearch.cluster.metadata.IndexNameExpressionResolver;
import org.elasticsearch.cluster.node.DiscoveryNodes;
import org.elasticsearch.common.io.stream.NamedWriteableRegistry;
import org.elasticsearch.common.network.NetworkService;
import org.elasticsearch.common.settings.ClusterSettings;
import org.elasticsearch.common.settings.IndexScopedSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.settings.SettingsFilter;
import org.elasticsearch.common.util.BigArrays;
import org.elasticsearch.common.util.concurrent.ThreadContext;
import org.elasticsearch.common.xcontent.NamedXContentRegistry;
import org.elasticsearch.http.HttpServerTransport;
import org.elasticsearch.http.HttpServerTransport.Dispatcher;
import org.elasticsearch.indices.breaker.CircuitBreakerService;
import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.plugins.NetworkPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestHandler;
import org.elasticsearch.threadpool.ThreadPool;
import org.elasticsearch.transport.TransportInterceptor;

import in.lineofcode.elasticsearch.rest.HelloRestAction;

/**
 * ElasticSearch Demo Plugin
 * @author Gaurav Rai Mazra
 *
 */
public class ElasticSearchDemoPlugin extends Plugin implements ActionPlugin, NetworkPlugin {
	@Override
	public List<RestHandler> getRestHandlers(Settings settings, RestController restController,
			ClusterSettings clusterSettings, IndexScopedSettings indexScopedSettings, SettingsFilter settingsFilter,
			IndexNameExpressionResolver indexNameExpressionResolver, Supplier<DiscoveryNodes> nodesInCluster) {
		return Collections.singletonList(new HelloRestAction(settings, restController));
	}
	
	@Override
	public List<TransportInterceptor> getTransportInterceptors(NamedWriteableRegistry namedWriteableRegistry,
			ThreadContext threadContext) {
		return NetworkPlugin.super.getTransportInterceptors(namedWriteableRegistry, threadContext);
	}
	
	@Override
	public Map<String, Supplier<HttpServerTransport>> getHttpTransports(Settings settings, ThreadPool threadPool,
			BigArrays bigArrays, CircuitBreakerService circuitBreakerService,
			NamedWriteableRegistry namedWriteableRegistry, NamedXContentRegistry xContentRegistry,
			NetworkService networkService, Dispatcher dispatcher) {
		return NetworkPlugin.super.getHttpTransports(settings, threadPool, bigArrays, circuitBreakerService,
				namedWriteableRegistry, xContentRegistry, networkService, dispatcher);
	}
}
