import java.util.*;

/*
 * An environment is expressed as Map<String,Integer>.
 */

public interface ExpParseTree extends ParseTree {
    int interpret(Map<String,Integer> env)
        throws InterpreterException;
}