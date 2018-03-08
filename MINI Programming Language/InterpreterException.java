public class InterpreterException extends Exception {
    public InterpreterException() {
        super("Divided by Zero!");
    }

    public InterpreterException(String v) {
        super("The variable " + v + " has not been assigned!");
    }
}