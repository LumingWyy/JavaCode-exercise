import java.util.*;

public class TokenList extends ArrayList<Token>
{
    private int idx;

    public TokenList() {
        idx = 0;
    }

    public void init() {
        idx = 0;
    }

    public StmParseTree parse() throws SyntaxErrorException {
        assert(idx < 0 || idx > size());
        return S();
    }

    private ExpParseTree F() throws SyntaxErrorException {
        Token t1, t2, t3;
        ExpParseTree e;
        NumParseTree n;
        VarParseTree v;

        if (idx == size()) {
            // Syntax error!!!
            throw new
                SyntaxErrorException("a number or a variable or - or (",
                                     "nothing");
        }
        t1 = get(idx++);
        switch (t1.getName()) {
        case NUM:
            return new NumParseTree(t1.getNum());
        case VAR:
            return new VarParseTree(t1.getVar());
        case LPAR:
            e = E();
            if (idx == size()) {
                // Syntax error!!!
                throw new SyntaxErrorException(")", "nothing");
            }
            t2 = get(idx++);
            if (t2.getName() != TokenName.RPAR) {
                // Syntax error!!!
                throw new SyntaxErrorException(")",t2);
            }
            return e;
        case MINUS:
            if (idx == size()) {
                // Syntax error!!!
                throw new
                    SyntaxErrorException("a number or a variable or (",
                                         "nothing");
            }
            t2 = get(idx++);
            switch (t2.getName()) {
            case NUM:
                n = new NumParseTree(t2.getNum());
                return new UmiParseTree(n);
            case VAR:
                v = new VarParseTree(t2.getVar());
                return new UmiParseTree(v);
            case LPAR:
                e = E();
                if (idx == size()) {
                    // Syntax error!!!
                    throw new SyntaxErrorException(")", "nothing");
                }
                t3 = get(idx++);
                if (t3.getName() != TokenName.RPAR) {
                    // Syntax error!!!
                    throw new SyntaxErrorException(")",t3);
                }
                return new UmiParseTree(e);
            default:
                // Syntax error!!!
                throw new
                    SyntaxErrorException("a number or a variable or (",t2);
            }
        default:
            // Syntax error!!!
            throw new
                SyntaxErrorException("a number or a variable or - or (",t1);
        }
    }

    private ExpParseTree E1() throws SyntaxErrorException {
        ExpParseTree e = F();
        return E11(e);
    }

    private ExpParseTree E11(ExpParseTree e) throws SyntaxErrorException {
        Token t1;
        ExpParseTree e1, e2;

        if (idx == size()) {
            return e;
        }
        t1 = get(idx++);
        switch (t1.getName()) {
        case MUL:
            e1 = F();
            e2 = new MulParseTree(e,e1);
            return E11(e2);
        case QUO:
            e1 = F();
            e2 = new QuoParseTree(e,e1);
            return E11(e2);
        case REM:
            e1 = F();
            e2 = new RemParseTree(e,e1);
            return E11(e2);
        default:
            idx--;
            return e;
        }
    }

    private ExpParseTree E2() throws SyntaxErrorException {
        ExpParseTree e = E1();
        return E22(e);
    }

    private ExpParseTree E22(ExpParseTree e) throws SyntaxErrorException {
        Token t1;
        ExpParseTree e1, e2;

        if (idx == size()) {
            return e;
        }
        t1 = get(idx++);
        switch (t1.getName()) {
        case PLUS:
            e1 = E1();
            e2 = new AddParseTree(e,e1);
            return E22(e2);
        case MINUS:
            e1 = E1();
            e2 = new SubParseTree(e,e1);
            return E22(e2);
        default:
            idx--;
            return e;
        }
    }

    private ExpParseTree E() throws SyntaxErrorException {
        return E2();
    }

    private StmParseTree S() throws SyntaxErrorException {
        Token t1,t2,t3;
        ExpParseTree e;
        StmParseTree s;
        AssignParseTree as;

        if (idx == size())
            return new EmptyParseTree();
        t1 = get(idx++);
        switch (t1.getName()) {
        case VAR:
            if (idx == size()) {
                // Syntax error!!!
                throw new SyntaxErrorException(":=", "nothing");
            }
            t2 = get(idx++);
            if (t2.getName() != TokenName.ASSIGN) {
                // Syntax error!!!
                throw new SyntaxErrorException(":=",t2);
            }
            e = E();
            if (idx == size()) {
                // Syntax error!!!
                throw new SyntaxErrorException(";", "nothing");
            }
            t3 = get(idx++);
            if (t3.getName() != TokenName.SEMC) {
                // Syntax error!!!
                throw new SyntaxErrorException(";",t3);
            }
            as = new AssignParseTree(new VarParseTree(t1.getVar()),e);
            s = S();
            if (s instanceof EmptyParseTree) {
                return as;
            } else {
                return new SCompParseTree(as,s);
            }
        default:
            // Syntax error!!!
            throw new
                SyntaxErrorException("a var",t1);
        }
    }
}
