import java.util.*;
/* name: Wang Luming
 * student id :1710245
 * date : 2018/01/19
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
