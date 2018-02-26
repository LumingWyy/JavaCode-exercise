import java.util.*;
/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/12
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
