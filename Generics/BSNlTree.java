import java.util.*;
/* name: Wang Luming

 * */

public class BSNlTree<K extends Comparable<? super K>, V> implements BSTree<K, V> {
	private K key;
	private V val;
	private BSTree<K, V> left;
	private BSTree<K, V> right;

	public BSNlTree(K k, V v, BSTree<K, V> l, BSTree<K, V> r) {
		key = k;
		val = v;
		left = l;
		right = r;
	}

	public BSNlTree<K, V> put(K k, V v) {
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
		int cmp = k.compareTo(key);
		if (cmp == 0) {
			return (V) val;
		}
		if (cmp < 0) {
			return (V) left.get(k);
		}
		return (V) right.get(k);
	}
	
	public String toString() {
		return "<" + this.key + "," + this.val + "," + this.left + "," + this.right + ">";
	}
}
