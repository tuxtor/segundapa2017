package gt.edu.url.segundaconvocatoria;

/**
 *
 * @author tuxtor
 */
public interface FavoriteList<E> {
    public void access(E e);
    public void remove(E e);
    public Iterable<E> getFavorites(int k);
}
