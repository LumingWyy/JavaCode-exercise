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
        case LT: return "<";
        case GT: return ">";
        case EQ: return "=";
        case NEQ: return "!=";
        case AND: return "&&";
        case OR: return "||";
        case ASSIGN: return ":=";
        case IF: return "if";
        case THEN: return "then";
        case ELSE: return "else";
        case FI: return "fi";
        case WHILE: return "while";
        case DO: return "do";
        case OD: return "od";
        case NUM: return "num=" + num;
        case VAR: return "var: " + var;
        case UNDEF: return "undef: " + var;
        default:
            // You never get here!
            throw new IllegalStateException("token(" + num + "," + var + ")");
        }
    }
}
