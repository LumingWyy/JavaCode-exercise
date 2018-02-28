import java.util.*;

public class SimpleCalculator {
	private SourceCode sc;
	private ExpParseTree ept;
	private VirtualMachine vm;

	public SimpleCalculator() {
		sc = null;
		ept = null;
		vm = null;
	}

	public void in(String expInStr) {
		sc = new SourceCode(expInStr);
		TokenList tl = sc.scan();
		try {
			ept = tl.parse();
			vm = null;
			System.out.println("Successfully loaded.");
		} catch (SyntaxErrorException e) {
			ept = null;
			vm = null;
			System.err.println(e.getMessage());
		}
	}

	public void compile() {
		if (ept == null) {
			System.err.println("No program loaded!");
		} else {
			List<Command> cl = ept.genCode();
			vm = new VirtualMachine(cl);
			System.out.println("Successfully compiled.");
		}
	}

	public void run() {
		if (vm == null) {
			System.err.println("No compiled!");
		} else {
			try {
				Stack<Integer> stk = new Stack<Integer>();
				vm.reset(0, stk);
				int x = vm.run();
				System.out.println(x);
			} catch (VMException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public void showSourceCode() {
		if (vm == null) {
			System.err.println("No compiled!");
		} else {
			System.out.println(sc);
		}
	}

	public void showParseTree() {
		if (vm == null) {
			System.err.println("No compiled!");
		} else {
			System.out.println(ept.genCode());
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