import java.util.*;
import java.io.*;
import java.util.regex.*;

public class ACCLP {
	private static void showBanner() {
		System.out.println("*************************");
		System.out.println("* Assignment Calculator *");
		System.out.println("*************************");
		System.out.print("AssignCal> ");
	}

	private static void help() {
		System.out.println("help - show this");
		System.out.print("show [sc|pt|cl] - show source code, ");
		System.out.println("parse tree or code list");
		System.out.println("in file - load a program from file");
		System.out.println("interpret - interpret the loaded program");
		System.out.println("compile - compile the loaded program");
		System.out.println("run - run the compiled program");
		System.out.println("quit - quit the calculator");
	}

	public static void main(String[] args) throws IOException {
		AssignCalculator ac = new AssignCalculator();
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
			} else if (line.equals("interpret")) {
				ac.interpret();
			} else if (line.equals("compile")) {
				ac.compile();
			} else if (line.equals("run")) {
				ac.run();
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
						ac.showSourceCode();
					} else if (flag.equals("pt")) {
						ac.showParseTree();
					} else if (flag.equals("cl")) {
						ac.showCodeList();
					} else {
						System.err.println("Usage: show [sc|pt|cl]");
					}
				}
			} else if (line.equals("in")) {
				System.err.println("Usage: in fileName");
			} else if (Pattern.matches("in[ \t].*", line)) {
				String[] la = line.split("[ \t]", 2);
				if (la.length < 2) {
					// You never get here!
					assert false : "In in command: " + line;
				} else {
					ac.in(la[1].trim());
				}
			} else {
				System.err.println("No such a command!!!");
			}
			System.out.print("AssignCal> ");
		}
		System.out.println("bye bye!!");
	}
}
