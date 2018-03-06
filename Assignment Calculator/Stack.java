import java.util.*;

public class Stack<E> extends ArrayList<E> {
    public Stack() {
        super();
    }

    public void push(E elem) {
        super.add(elem);
    }

    public E pop()
        throws ArrayIndexOutOfBoundsException
    {
        return super.remove(super.size()-1);
    }

    public E top()
        throws ArrayIndexOutOfBoundsException
    {
        return super.get(super.size()-1);
    }
}

