import java.util.*;

public abstract class ExpParseTree {
	public abstract List<Command> compile();

	public List<Command> genCode() {
		List<Command> cl;
		cl = this.compile();
		cl.add(new Command(CommandName.QUIT));
		return cl;
	}
}