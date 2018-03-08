import java.util.*;

public class EmptyParseTree
    extends StmParseTree
{
    public EmptyParseTree() { }

    public Map<String,Integer>
        interpret(Map<String,Integer> env)
    {
        return env;
    }

    public List<Command> compile() {
        return new ArrayList<Command>();
    }

    public String toString() {
        return "empty";
    }
}