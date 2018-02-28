import java.util.*;
/* name: Wang Luming

 * */

public class UmiParseTree implements ExpParseTree {

	private ExpParseTree ept;

	public UmiParseTree(ExpParseTree e) {
		ept = e;
	}

	public int calculate() throws CalculatorException {
		int n1 = ept.calculate();
		return -n1;
	}

	public String toString() {
		return "umi(" + ept +  ")";
	}

}
