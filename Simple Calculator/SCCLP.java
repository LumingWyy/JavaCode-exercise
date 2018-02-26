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
		System.out.println("quit - quit the calculator");
		System.out.println("exp - calculate exp");
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
			} else {
				sc.calculate(line);
			}
			System.out.print("SimpleCal> ");
		}
		System.out.println("bye bye!!");
	}
}
