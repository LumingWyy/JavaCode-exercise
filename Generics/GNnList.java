import java.util.*;
/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/12
 * */

public class GNnList<E> implements GList<E> {
	private E head;
	private GList<E> tail;

	public GNnList(E e, GList<E> list) {
		head = e;
		tail = list;
	}

	public GNnList<E> cons(E e) {
		return new GNnList<E>(e, this);
	}

	public GNnList<E> append(GList<E> list) {
		return (GNnList<E>) tail.append(list).cons(head);
	}
	
	public String toString() {
        return head.toString() + "," + tail.toString();
    }
}
