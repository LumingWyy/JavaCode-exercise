import java.util.*;
import java.io.*;

public class SimpleCalculator {
	public SimpleCalculator() {
	}

	public void calculate(String exp) {
		SourceCode sc = new SourceCode(exp);
		TokenList tl = sc.scan();
		System.out.println(tl);
		try {
			ExpParseTree ept = tl.parse();
			System.out.println(ept);
			System.out.println(ept.calculate());
		} catch (SyntaxErrorException e) {
			System.err.println(e.getMessage());
		} catch (CalculatorException e) {
			System.err.println(e.getMessage());
		}
	}
}
