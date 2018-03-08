public class VMException extends Exception {
    public VMException() {
        super("Divided by Zero!");
    }

    public VMException(String v) {
        super("The variable " + v + " has not been assigned!");
    }

    public VMException(int pc, int size) {
        super("Out of bounds - pc: " + pc + ", code size: " + size);
    }

    public VMException(Stack<Integer> stk) {
        super("Insufficient values on stack - #stack: " + stk.size());
    }

    public VMException(Stack<Integer> stk, int n) {
        super("Stack should be empty but there are " + n + " values!");
    }
}