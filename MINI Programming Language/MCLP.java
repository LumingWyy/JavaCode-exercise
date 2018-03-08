import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MCLP {
    private static void showBanner() {
        System.out.println("****************************************");
        System.out.println("* Minila (a MINI programming LAnguage) *");
        System.out.println("* in Java                              *");
        System.out.println("****************************************");
        System.out.print("minila> ");
    }

    private static void help() {
        System.out.println("help - show this");
        System.out.print("show [sc|pt|cl] - show source code, ");
        System.out.println("parse tree or code list");
        System.out.println("in file - load a program from file");
        System.out.println("interpret - interpret the loaded program");
        System.out.println("compile - compile the loaded program");
        System.out.println("run - run the compiled program");
        System.out.println("quit - quit Minila in Java");
    }

    public static void main(String[] args)
        throws IOException
    {
        Minila minila = new Minila();
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
                minila.interpret();
            } else if (line.equals("compile")) {
                minila.compile();
            } else if (line.equals("run")) {
                minila.run();
            } else if (line.equals("show")) {
                System.err.println("Usage: show [sc|pt|cl]");
            } else if (Pattern.matches("show[ \t].*",line)) {
                String[] la = line.split("[ \t]",2);
                if (la.length < 2) {
                    // You never get here!
                    assert false : "In show command: " + line;
                } else {
                    String flag = la[1].trim();
                    if (flag.equals("sc")) {
                        minila.showSourceCode();
                    } else if (flag.equals("pt")) {
                        minila.showParseTree();
                    } else if (flag.equals("cl")) {
                        minila.showCodeList();
                    } else {
                        System.err.println("Usage: show [sc|pt|cl]");
                    }
                }
            } else if (line.equals("in")) {
                System.err.println("Usage: in fileName");
            } else if (Pattern.matches("in[ \t].*",line)) {
                String[] la = line.split("[ \t]",2);
                if (la.length < 2) {
                    // You never get here!
                    assert false : "In in command: " + line;
                } else {
                    minila.in(la[1].trim());
                }
            } else {
                System.err.println("No such a command!!!");
            }
            System.out.print("minila> ");
        }
        System.out.println("bye bye!!");
    }
}
