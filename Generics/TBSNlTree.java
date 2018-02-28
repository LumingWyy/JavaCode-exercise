import java.util.*;
/* name: Wang Luming
 * */

public class TBSNlTree<K extends Comparable<K>, V> implements TBSTree<K, V> {
	private K key;
	private V val;
	private TBSTree<K, V> left;
	private TBSTree<K, V> right;

	public TBSNlTree(K k, V v, TBSTree<K, V> l, TBSTree<K, V> r) {
		key = k;
		val = v;
		left = l;
		right = r;
	}

	public TBSNlTree<K, V> put(K k, V v) {
		int cmp = k.compareTo(key);
		if (cmp == 0) {
			val = v;
		} else if (cmp < 0) {
			left = left.put(k, v);
		} else {
			right = right.put(k, v);
		}
		return this;
	}

	public V get(K k) {
		int i = k.compareTo(key);
		if (i == 0) {
			return (V) val;
		}
		if (i < 0) {
			return (V) left.get(k);
		}
		return (V) right.get(k);
	}
	
	public String toString() {
		return "<" + this.key + "," + this.val + "," + this.left + "," + this.right + ">";
	}
}
