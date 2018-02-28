import java.util.*;
/* name: Wang Luming
 * */

public class RemParseTree implements ExpParseTree {
	private ExpParseTree ept1, ept2;

	public RemParseTree(ExpParseTree e1, ExpParseTree e2) {
		ept1 = e1;
		ept2 = e2;
	}

	public int calculate() throws CalculatorException {
		int n1 = ept1.calculate();
		int n2 = ept2.calculate();
		if (n2 == 0) {
			throw new CalculatorException();
		}
		return n1 % n2;
	}

	public String toString() {
		return "rem(" + ept1 + "," + ept2 + ")";
	}
}
