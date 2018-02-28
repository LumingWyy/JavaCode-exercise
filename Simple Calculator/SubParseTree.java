import java.util.*;
/* name: Wang Luming

 * */

public class SubParseTree implements ExpParseTree {
	private ExpParseTree ept1, ept2;

	public SubParseTree(ExpParseTree e1, ExpParseTree e2) {
		ept1 = e1;
		ept2 = e2;
	}

	public int calculate() throws CalculatorException {
		int n1 = ept1.calculate();
		int n2 = ept2.calculate();
		return n1 - n2;
	}

	public String toString() {
		return "sub(" + ept1 + "," + ept2 + ")";
	}
}
