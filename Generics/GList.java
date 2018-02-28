import java.util.*;
/* name: Wang Luming

 * */

public abstract interface GList<E> {
	public abstract GList<E> cons(E e);

	public abstract GList<E> append(GList<E> list);
}
