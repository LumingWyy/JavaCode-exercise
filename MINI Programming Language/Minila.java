import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Minila {
    private SourceCode sc;
    private StmParseTree pt;
    private VirtualMachine vm;

    public Minila() {
        sc = null;
        pt = null;
        vm = null;
    }

    public void in(String file)
        throws IOException
    {
        FileReader fr = null;
        try {
            BufferedReader scbr;
            String scl, scstr;
            int c;
            TokenList tl;
            fr = new FileReader(file);
            scbr = new BufferedReader(fr);
            scstr = "";
            // while ((scl = scbr.readLine()) != null) {
            // scstr = scstr + " " + scl;
            while ((c = scbr.read()) != -1) {
                scstr = scstr + (char) c;
            }
            sc = new SourceCode(scstr.trim());
            tl = sc.scan();
            try {
                pt = tl.parse();
                vm = null;
                System.out.println("Successfully loaded.");
            } catch (SyntaxErrorException e) {
                pt = null;
                vm = null;
                System.err.println(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            pt = null;
            vm = null;
            System.err.println("No such file: " + file);
        } finally {
            if (fr != null)
                fr.close();
        }
    }

    public void interpret() {
        if (pt == null) {
            System.err.println("No program loaded!");
        } else {
            try {
                Map<String,Integer> rslt;
                Map<String,Integer> env = new HashMap<String,Integer>();
                rslt = pt.interpret(env);
                System.out.println(rslt);
            } catch (InterpreterException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void compile() {
        if (pt == null) {
            System.err.println("No program loaded!");
        } else {
            List<Command> cl = pt.genCode();
            vm = new VirtualMachine(cl);
            System.out.println("Successfully compiled.");
        }
    }

    public void run() {
        if (vm == null) {
            System.err.println("No compiled!");
        } else {
            try {
                Map<String,Integer> rslt;
                int pc = 0;
                Stack<Integer> stk = new Stack<Integer>();
                Map<String,Integer> env = new HashMap<String,Integer>();
                vm.reset(pc,stk,env);
                rslt = vm.run();
                System.out.println(rslt);
            } catch (VMException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void showSourceCode() {
        if (sc == null) {
            System.err.println("No program loaded!");
        } else {
            System.out.println(sc);
        }
    }

    public void showParseTree() {
        if (pt == null) {
            System.err.println("No parse tree available!");
        } else {
            System.out.println(pt);
        }
    }

    public void showCodeList() {
        if (vm == null) {
            System.err.println("No compiled!");
        } else {
            System.out.println(vm.getComList());
        }
    }
}
