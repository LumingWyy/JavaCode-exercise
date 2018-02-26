import java.util.*;

public class NumParseTree implements ExpParseTree {
	private int val;

	public NumParseTree(int x) {
		val = x;
	}

	public int calculate() {
		return val;
	}

	public String toString() {
		return "" + val;
	}
}
