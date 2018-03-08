import java.util.*;

public class EqParseTree
    implements ExpParseTree
{
    private ExpParseTree ept1, ept2;

    public EqParseTree(ExpParseTree e1, ExpParseTree e2) {
        ept1 = e1;
        ept2 = e2;
    }

    public int interpret(Map<String,Integer> env)
        throws InterpreterException
    {
        int n1 = ept1.interpret(env);
        int n2 = ept2.interpret(env);
        return n1 == n2 ? 1 : 0 ;
    }

    public List<Command> compile() {
        List<Command> cl;
        cl = ept1.compile();
        cl.addAll(ept2.compile());
        cl.add(new Command(CommandName.EQ));
        return cl;
    }

    public String toString() {
        return "eq(" + ept1 + "," + ept2 + ")";
    }
}
