public class Token {
    private TokenName name;
    private int num;
    private String var;

    public Token(TokenName n) {
        name = n;
    }

    public Token(TokenName n, int x) {
        name = n;
        num = x;
    }

    public Token(TokenName n, String v) {
        name = n;
        var = v;
    }

    public TokenName getName() { return name; }
    public int getNum() { return num; }
    public String getVar() { return var; }

    public String toString()
        throws IllegalStateException
    {
        switch (name) {
        case SEMC: return ";";
        case LPAR: return "(";
        case RPAR: return ")";
        case MUL: return "*";
        case QUO: return "/";
        case REM: return "%";
        case PLUS: return "+";
        case MINUS: return "-";
        case ASSIGN: return ":=";
        case NUM: return "num=" + num;
        case VAR: return "var: " + var;
        case UNDEF: return "undef: " + var;
        default:
            // You never get here!
            throw new IllegalStateException("token(" + num + "," + var + ")");
        }
    }
}
