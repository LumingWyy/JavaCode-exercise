import java.util.*;

public class IfParseTree extends StmParseTree {
	private ExpParseTree exp;
	private StmParseTree stm1, stm2;

	public IfParseTree(ExpParseTree e, StmParseTree s1, StmParseTree s2) {
		exp = e;
		stm1 = s1;
		stm2 = s2;
	}

	public Map<String, Integer> interpret(Map<String, Integer> env) throws InterpreterException {
		int n = exp.interpret(env);
		// Map<String, Integer> env1;
		// if (n != 0) {
		// env1 = stm1.interpret(env);
		// return env1;
		// } else {
		// env1 = stm2.interpret(env);
		// return env1;
		// }
		if (n != 0) {
			env = stm1.interpret(env);
		} else {
			env = stm2.interpret(env);
		}
		return env;
	}

	public List<Command> compile() {
		List<Command> cl1 = exp.compile();
		List<Command> cl2 = stm1.compile();
		List<Command> cl3 = stm2.compile();
		cl1.add(new Command(CommandName.CJMP, 2));
		cl1.add(new Command(CommandName.JMP, cl2.size() + 2));
		cl1.addAll(cl2);
		cl1.add(new Command(CommandName.JMP, cl3.size() + 1));
		cl1.addAll(cl3);
		return cl1;
	}

	public String toString() {
		return "if(" + exp + "," + stm1 + "," + stm2 + ")";
	}
}