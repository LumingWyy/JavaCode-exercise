import java.util.*;

/*
 * An environment is expressed as Map<String,Integer>.
 */

public abstract class StmParseTree implements ParseTree {
    public abstract Map<String,Integer>
        interpret(Map<String,Integer> env)
        throws InterpreterException;

    public List<Command> genCode() {
        List<Command> cl;
        cl = this.compile();
        cl.add(new Command(CommandName.QUIT));
        return cl;
    }
}
