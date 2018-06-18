package in.lineofcode.patterns.observer;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Gaurav Rai Mazra
 * <a href="https://gauravbytes.com">Blog - GauravBytes</a>
 *
 */
public class Observable<E> {
	private List<Observer<E>> observers = new CopyOnWriteArrayList<>();
	
	public enum Signal {
		START, INTERUPT, STOP;
	}
	
	public void addObserver(Observer<E> observer) {
		Objects.requireNonNull(observer);
		
		if (!observers.contains(observer)) {
			observers.add(observer);
		}
	}
	
	public void removeObserver(Observer<E> observer) {
		Objects.requireNonNull(observer);
		observers.remove(observer);
	}
	
	public void notifyObservers(E event) {
		Objects.requireNonNull(event);
		
		Iterator<Observer<E>> iterator = observers.iterator();
		
		while(iterator.hasNext()) {
			iterator.next().update(this, event);
		}
	}
}
