import java.util.List;

public class SubParseTree extends ExpParseTree {
	private ExpParseTree ept1, ept2;

	public SubParseTree(ExpParseTree e1, ExpParseTree e2) {
		ept1 = e1;
		ept2 = e2;
	}

	public List<Command> compile() {
		List<Command> cl;
		cl = ept1.compile();
		cl.addAll(ept2.compile());
		cl.add(new Command(CommandName.SUB));
		return cl;
	}
}