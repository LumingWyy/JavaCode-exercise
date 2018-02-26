import java.util.*;
/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/12
 * */

public class TBSLeaf<K extends Comparable<K>, V> implements TBSTree<K, V> {
	public TBSNlTree<K, V> put(K k, V v) {
		return new TBSNlTree<K, V>(k, v, this, this);
	}

	public V get(K k) {
		return null;
	}

}
