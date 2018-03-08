public class Command {
    private CommandName name;
    private int num;
    private String var;

    public Command(CommandName n) {
        name = n;
    }

    public Command(CommandName n, int x) {
        name = n;
        num = x;
    }

    public Command(CommandName n, String v) {
        name = n;
        var = v;
    }

    public CommandName getName() { return name; }
    public int getNum() { return num; }
    public String getVar() { return var; }

    public String toString()
        throws IllegalStateException
    {
        switch (name) {
        case PUSH: return "push(" + num + ")";
        case LOAD: return "load(" + var + ")";
        case STORE: return "store(" + var + ")";
        case MONE: return "mone";
        case MUL: return "mul";
        case QUO: return "quo";
        case REM: return "rem";
        case ADD: return "add";
        case SUB: return "sub";
        case LT: return "lt";
        case GT: return "gt";
        case EQ: return "eq";
        case NEQ: return "neq";
        case AND: return "and";
        case OR: return "or";
        case JMP: return "jmp(" + num + ")";
        case CJMP: return "cjmp(" + num + ")";
        case QUIT: return "quit";
        default:
            // You never get here!
            throw new IllegalStateException("command(" + num
                                            + "," + var + ")");
        }
    }
}
