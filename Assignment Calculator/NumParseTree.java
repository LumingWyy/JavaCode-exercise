import java.util.*;

public class NumParseTree
    implements ExpParseTree
{
    private int val;

    public NumParseTree(int x) {
        val = x;
    }

    public int interpret(Map<String,Integer> env) {
        return val;
    }

    public List<Command> compile() {
        List<Command> cl
            = new ArrayList<Command>();
        cl.add(new Command(CommandName.PUSH,val));
        return cl;
    }

    public String toString() {
        return "" + val;
    }
}
