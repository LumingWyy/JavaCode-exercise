import java.util.*;

public class AssignParseTree extends StmParseTree {
	private VarParseTree var;
	private ExpParseTree exp;

	public AssignParseTree(VarParseTree v, ExpParseTree e) {
		var = v;
		exp = e;
	}

	public AssignParseTree(VarParseTree v) {
		var = v;
	}

	public VarParseTree getVar() {
		return var;
	}

	public ExpParseTree getExp() {
		return exp;
	}

	public void setExp(ExpParseTree e) {
		exp = e;
	}

	public Map<String, Integer> interpret(Map<String, Integer> env) throws InterpreterException {
		int n = exp.interpret(env);
		env.put(var.getName(), n);
		return env;
	}

	public List<Command> compile() {
		List<Command> cl;
		cl = exp.compile();
		cl.add(new Command(CommandName.STORE, var.getName()));
		return cl;
	}

	public String toString() {
		return "assign(" + var + "," + exp + ")";
	}
}