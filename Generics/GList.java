import java.util.*;
/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/12
 * */

public abstract interface GList<E> {
	public abstract GList<E> cons(E e);

	public abstract GList<E> append(GList<E> list);
}
