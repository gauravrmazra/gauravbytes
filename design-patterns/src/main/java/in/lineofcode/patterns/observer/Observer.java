package in.lineofcode.patterns.observer;

/**
 * @author Gaurav Rai Mazra
 * <a href="https://gauravbytes.com">Blog - GauravBytes</a>
 *
 */
public interface Observer<E> {
	public void update(Observable<E> owner, E event);
}
