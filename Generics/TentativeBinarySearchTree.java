import java.util.*;
/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/12
 * */

public class TentativeBinarySearchTree<K extends Comparable<K>, V> {
	private TBSTree<K, V> bst;

	public TentativeBinarySearchTree() {
		bst = new TBSLeaf<K, V>();
	}

	public void put(K k, V v) {
		bst = bst.put(k, v);
	}

	public V get(K k) {
		return (V) bst.get(k);
	}

}
