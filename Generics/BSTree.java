import java.util.*;
/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/12
 * */

public interface BSTree<K extends Comparable<? super K>, V> {
	public abstract BSTree<K, V> put(K k, V v);

	public abstract V get(K k);
}
