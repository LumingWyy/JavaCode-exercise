public class SyntaxErrorException extends Exception {
    public SyntaxErrorException(String s) {
        super(s);
    }
    public SyntaxErrorException(String s, Token t) {
        super("There should be " + s + " but " + t + "!");
    }
    public SyntaxErrorException(String s1, String s2) {
        super("There should be " + s1 + " but " + s2 + "!");
    }
}