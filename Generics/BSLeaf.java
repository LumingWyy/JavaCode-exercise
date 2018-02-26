import java.util.*;
/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/16
 * */

public class BSLeaf<K extends Comparable<? super K>, V> implements BSTree<K, V> {
	public BSNlTree<K, V> put(K k, V v) {
		return new BSNlTree<K, V>(k, v, this, this);
	}

	public V get(K k) {
		return null;
	}
	
	public String toString() {
    	return "leaf";
  	}
}
