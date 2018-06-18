package in.lineofcode.patterns.observer;

import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.Lists;

import in.lineofcode.patterns.observer.MyTask.Result;
import in.lineofcode.patterns.observer.Observable.Signal;

/**
 * @author Gaurav Rai Mazra
 * <a href="https://gauravbytes.com">Blog - GauravBytes</a>
 *
 */
public class ObserverPatternMain {
	private static final Logger LOG = Logger.getLogger(ObserverPatternMain.class.getSimpleName());

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Observable<Signal> observable = new Observable<>();
		
		List<List<Integer>> partitionedList = Lists
				.partition(IntStream.range(0, 1000000).mapToObj(Integer::valueOf).collect(Collectors.toList()), 100000);
		
		LOG.info(() -> String.format("PartitionedList size: [%d]", partitionedList.size()));
		ExecutorService es = Executors.newFixedThreadPool(10);
		CompletionService<Result> completionService = new ExecutorCompletionService<>(es);
		int i = 0;
		for (List<Integer> tasks : partitionedList) {
			MyTask task = new MyTask("Task-" + i++, tasks);
			observable.addObserver(task);
			completionService.submit(task);
		}
		
		TimeUnit.MILLISECONDS.sleep(20l);

		observable.notifyObservers(Signal.INTERUPT);
		
		int j = 0;
		while (j++ != i) {
			Future<Result> completedTasks = completionService.take();
			Result result = completedTasks.get();
			LOG.info(result::toString);
		}
		
		es.shutdown();
	}
}
