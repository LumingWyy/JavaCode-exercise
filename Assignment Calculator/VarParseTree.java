import java.util.*;

public class VarParseTree
    implements ExpParseTree
{
    private String name;

    public VarParseTree(String s) {
        name = s;
    }

    public int interpret(Map<String,Integer> env)
        throws InterpreterException
    {
        try {
            return env.get(name);
        } catch (NullPointerException e) {
            throw new InterpreterException(name);
        }
    }

    public List<Command> compile() {
        List<Command> cl
            = new ArrayList<Command>();
        cl.add(new Command(CommandName.LOAD,name));
        return cl;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}