package gt.edu.url.segundaconvocatoria;

/**
 *
 * @author tuxtor
 */
public interface DoubleStack<E> {
        boolean isEmpty();
    
	int redSize();
	void redPush(E e);
	E redTop();
	E redPop();
        
        int blueSize();
	void bluePush(E e);
	E blueTop();
	E bluePop();
}
