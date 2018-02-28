import java.util.*;
import java.io.*;
import java.util.regex.*;

public class SCCLP {
	private static void showBanner() {
		System.out.println("*********************");
		System.out.println("* Simple Calculator *");
		System.out.println("*********************");
		System.out.print("SimpleCal> ");
	}

	private static void help() {
		System.out.println("help - show this");
		System.out.print("show [sc|pt|cl] - show source code, ");
		System.out.println("parse tree or code list");
		System.out.println("in exp - load an expression exp");
		System.out.println("compile - compile the loaded expression");
		System.out.println("run - run the compiled expression");
		System.out.println("quit - quit the calculator");
	}

	public static void main(String[] args) throws IOException {
		SimpleCalculator sc = new SimpleCalculator();
		String line;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		showBanner();
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.equals("")) {
				// Nothing is done.
			} else if (line.equals("quit")) {
				break;
			} else if (line.equals("help")) {
				help();
			} else if (line.equals("compile")) {
				sc.compile();
			} else if (line.equals("run")) {
				sc.run();
			} else if (line.equals("show")) {
				System.err.println("Usage: show [sc|pt|cl]");
			} else if (Pattern.matches("show[ \t].*", line)) {
				String[] la = line.split("[ \t]", 2);
				if (la.length < 2) {
					// You never get here!
					assert false : "In show command: " + line;
				} else {
					String flag = la[1].trim();
					if (flag.equals("sc")) {
						sc.showSourceCode();
					} else if (flag.equals("pt")) {
						sc.showParseTree();
					} else if (flag.equals("cl")) {
						sc.showCodeList();
					} else {
						System.err.println("Usage: show [sc|pt|cl]");
					}
				}
			} else if (line.equals("in")) {
				System.err.println("Usage: in exp");
			} else if (Pattern.matches("in[ \t].*", line)) {
				String[] la = line.split("[ \t]", 2);
				if (la.length < 2) {
					// You never get here!
					assert false : "In in command: " + line;
				} else {
					sc.in(la[1].trim());
				}
			} else {
				System.err.println("No such a command!!!");
			}
			System.out.print("SimpleCal> ");
		}
		System.out.println("bye bye!!");
	}
}
