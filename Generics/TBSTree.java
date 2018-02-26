import java.util.*;
/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/12
 * */

public interface TBSTree<K extends Comparable<K>, V> {
	public abstract TBSTree<K, V> put(K k, V v);

	public abstract V get(K k);
}
