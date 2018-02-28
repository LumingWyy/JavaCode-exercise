import java.util.*;
/* name: Wang Luming
 * */

public class TBSLeaf<K extends Comparable<K>, V> implements TBSTree<K, V> {
	public TBSNlTree<K, V> put(K k, V v) {
		return new TBSNlTree<K, V>(k, v, this, this);
	}

	public V get(K k) {
		return null;
	}

}
