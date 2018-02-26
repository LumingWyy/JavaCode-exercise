import java.util.*;
/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/12
 * */

public class BinarySearchTree<K extends Comparable<? super K>, V> {
	private BSTree<K, V> bst;

	public BinarySearchTree() {
		bst = new BSLeaf<K, V>();
	}

	public void put(K k, V v) {
		bst = bst.put(k, v);
	}

	public V get(K k) {
		return (V) bst.get(k);
	}
}
