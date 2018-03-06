import java.util.*;

public class UmiParseTree implements ExpParseTree {
	private int val;
	private ExpParseTree ept;

	public UmiParseTree(ExpParseTree e) {
		ept = e;
	}

	public int interpret(Map<String, Integer> env) throws InterpreterException {
		int n = ept.interpret(env);
		val = n;
		return -val;
	}

	public List<Command> compile() {
		List<Command> cl = new ArrayList<Command>();
		cl.add(new Command(CommandName.MONE, val));
		return cl;
	}

	public String toString() {
		return "umi(" + val + ")";
	}
}
