package in.lineofcode.patterns.observer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

import in.lineofcode.patterns.observer.MyTask.Result;
import in.lineofcode.patterns.observer.Observable.Signal;

/**
 * @author Gaurav Rai Mazra <a href="https://gauravbytes.com">Blog -
 *         GauravBytes</a>
 *
 */
public class MyTask implements Observer<Signal>, Callable<Result> {
	private static final Logger LOG = Logger.getLogger(MyTask.class.getSimpleName());

	private final AtomicReference<Signal> signal = new AtomicReference<>(Signal.START);
	private final List<Integer> tasks;
	private final String name;

	public static class Result {
		private String taskName;
		private List<Integer> processedTasks;

		public Result(String taskName, List<Integer> processedTasks) {
			this.taskName = taskName;
			this.processedTasks = processedTasks;
		}

		@Override
		public String toString() {
			return "Result [taskName=" + taskName + ", processedTasks=" + processedTasks.size() + "]";
		}
	}

	public MyTask(String name, List<Integer> tasks) {
		this.name = name;
		this.tasks = tasks;
	}

	@Override
	public void update(Observable<Signal> owner, Signal event) {
		LOG.info(() -> String.format("Event[%s] received by Task[%s] at time[%s]", event, name,
				LocalDateTime.now().toString()));
		signal.compareAndSet(Signal.START, event);
	}
	
	private boolean canProcess() {
		return signal.get() == Signal.START;
	}

	@Override
	public Result call() throws Exception {
		List<Integer> processedTasks = new ArrayList<>();
		if (canProcess()) {
			for (Integer task : tasks) {
				if (canProcess()) {
					processedTasks.add(task); // I can continue processing results
					TimeUnit.MILLISECONDS.sleep(1l);
				}
			}
		}
		LOG.info(() -> String.format("[%d]/ [%d] tasks processed by [%s]", processedTasks.size(), tasks.size(), name));
		return new Result(name, processedTasks);
	}
}
