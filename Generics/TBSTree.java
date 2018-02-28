import java.util.*;
/* name: Wang Luming
 * */

public interface TBSTree<K extends Comparable<K>, V> {
	public abstract TBSTree<K, V> put(K k, V v);

	public abstract V get(K k);
}
