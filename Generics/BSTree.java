import java.util.*;
/* name: Wang Luming

 * */

public interface BSTree<K extends Comparable<? super K>, V> {
	public abstract BSTree<K, V> put(K k, V v);

	public abstract V get(K k);
}
