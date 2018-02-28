import java.util.*;
/* name: Wang Luming

 * */

public class GNil<E> implements GList<E> {
	public GList<E> cons(E e) {
		return new GNnList<E>(e, this);
	}

	public GList<E> append(GList<E> list) {
		return list;
	}
	
	public String toString() { 
		return "nil"; 
	}
}
