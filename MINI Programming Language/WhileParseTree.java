import java.util.*;

public class WhileParseTree extends StmParseTree {
	private ExpParseTree exp;
	private StmParseTree stm;

	public WhileParseTree(ExpParseTree e, StmParseTree s) {
		exp = e;
		stm = s;
	}

	public Map<String, Integer> interpret(Map<String, Integer> env) throws InterpreterException {
		int n = exp.interpret(env);
		// if (n == 0) {
		// return env;
		// } else {
		// Map<String, Integer> env1 = stm.interpret(env);
		// Map<String, Integer> env2 = this.interpret(env1);
		// System.out.println(env2);
		// return env2;
		// }
		if (n != 0) {
			env = stm.interpret(env);
			env = this.interpret(env);
		}
		return env;
	}

	public List<Command> compile() {
		List<Command> cl1 = exp.compile();
		List<Command> cl2 = stm.compile();
		int m = -1 * (cl1.size() + cl2.size() + 2);
		cl1.add(new Command(CommandName.CJMP, 2));
		cl1.add(new Command(CommandName.JMP, cl2.size() + 2));
		cl1.addAll(cl2);
		cl1.add(new Command(CommandName.JMP, m));
		return cl1;
	}

	public String toString() {
		return "while(" + exp + "," + stm + ")";
	}
}