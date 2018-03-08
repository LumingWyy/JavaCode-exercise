/*
 * The grammar of Minila programming language:
 *
 *    P ::= S
 *
 *    S ::=                                   (empty statement)
 *          | var ':=' E ';'                  (assign statement)
 *          | 'if' E 'then' S 'else' S 'fi'   (if statement)
 *          | 'while' E 'do' S 'od'           (while statement)
 *          | S S                             (sequential composition)
 *
 *    E ::=   num
 *          | '-' num
 *          | var
 *          | '-' var
 *          | '(' E ')'
 *          | '-' '(' E ')'
 *          | E '*' E | E '/' E | E '%' E
 *          | E '+' E | E '-' E
 *          | E '<' E | E '>' E | E '=' E | E '!=' E
 *          | E '&&' E | E '||' E
 *
 *    num ::= [0-9]+
 *    var ::= [a-zA-Z][0-9a-zA-Z]*
 *
 * The grammar for expressions is rewritten as follows so that
 * a recursive descent parser can be used.
 *
 *     F ::= ['-'] num | ['-'] var | ['-'] '(' E ')'
 *     E1 ::= F E11
 *     E11 ::= eps | '*' F E11 | '/' F E11
 *     E2 ::= E1 E22
 *     E22 ::= eps | '+' E1 E22 | '-' E1 E22
 *     E3 ::= E2 E33
 *     E33 ::= eps | '<' E2 E33 | '>' E2 E33 | '=' E2 E33 | '!=' E2 E33
 *     E4 ::= E3 E44
 *     E44 ::= eps | '&&' E3 E44 | '||' E3 E44
 *     E ::= E4
 *
 * The precedence of the operators is as follows:
 *
 *     (unary) '-'            (strongest)
 *     '*', '/', '%'
 *     '+', (bynary) '-'
 *     '<', '>', '=', '!='
 *     '&&', '||'             (weakest)
 *
 * Every operator is left-associative, e.g. 3-2-1 is parsed as ((3-2)-1).
 *
 */

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
        return S(0);
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

    private ExpParseTree E3() throws SyntaxErrorException {
        ExpParseTree e = E2();
        return E33(e);
    }

    private ExpParseTree E33(ExpParseTree e) throws SyntaxErrorException {
        Token t1;
        ExpParseTree e1, e2;

        if (idx == size()) {
            return e;
        }
        t1 = get(idx++);
        switch (t1.getName()) {
        case LT:
            e1 = E2();
            e2 = new LtParseTree(e,e1);
            return E33(e2);
        case GT:
            e1 = E2();
            e2 = new GtParseTree(e,e1);
            return E33(e2);
        case EQ:
            e1 = E2();
            e2 = new EqParseTree(e,e1);
            return E33(e2);
        case NEQ:
            e1 = E2();
            e2 = new NeqParseTree(e,e1);
            return E33(e2);
        default:
            idx--;
            return e;
        }
    }

    private ExpParseTree E4() throws SyntaxErrorException {
        ExpParseTree e = E3();
        return E44(e);
    }

    private ExpParseTree E44(ExpParseTree e) throws SyntaxErrorException {
        Token t1;
        ExpParseTree e1, e2;

        if (idx == size()) {
            return e;
        }
        t1 = get(idx++);
        switch (t1.getName()) {
        case AND:
            e1 = E3();
            e2 = new AndParseTree(e,e1);
            return E44(e2);
        case OR:
            e1 = E3();
            e2 = new OrParseTree(e,e1);
            return E44(e2);
        default:
            idx--;
            return e;
        }
    }

    private ExpParseTree E() throws SyntaxErrorException {
        return E4();
    }

    private StmParseTree S(int level) throws SyntaxErrorException {
        Token t1,t2,t3,t4;
        ExpParseTree e, e1, e2;
        StmParseTree s, s1, s2;
        AssignParseTree as;
        IfParseTree is;
        WhileParseTree ws;
        VarParseTree v;

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
            s = S(level);
            if (s instanceof EmptyParseTree) {
                return as;
            } else {
                return new SCompParseTree(as,s);
            }
        case IF:
            e = E();
            if (idx == size()) {
                // Syntax error!!!
                throw new SyntaxErrorException("then", "nothing");
            }
            t2 = get(idx++);
            if (t2.getName() != TokenName.THEN) {
                // Syntax error!!!
                throw new SyntaxErrorException("then",t2);
            }
            s1 = S(level + 1);
            if (idx == size()) {
                // Syntax error!!!
                throw new SyntaxErrorException("else", "nothing");
            }
            t3 = get(idx++);
            if (t3.getName() != TokenName.ELSE) {
                // Syntax error!!!
                throw new SyntaxErrorException("else",t3);
            }
            s2 = S(level + 1);
            if (idx == size()) {
                // Syntax error!!!
                throw new SyntaxErrorException("fi", "nothing");
            }
            t4 = get(idx++);
            if (t4.getName() != TokenName.FI) {
                // Syntax error!!!
                throw new SyntaxErrorException("fi",t4);
            }
            is = new IfParseTree(e,s1,s2);
            s = S(level);
            if (s instanceof EmptyParseTree) {
                return is;
            } else {
                return new SCompParseTree(is,s);
            }
        case WHILE:
            e = E();
            if (idx == size()) {
                // Syntax error!!!
                throw new SyntaxErrorException("do", "nothing");
            }
            t2 = get(idx++);
            if (t2.getName() != TokenName.DO) {
                // Syntax error!!!
                throw new SyntaxErrorException("do",t2);
            }
            s1 = S(level + 1);
            if (idx == size()) {
                // Syntax error!!!
                throw new SyntaxErrorException("od", "nothing");
            }
            t3 = get(idx++);
            if (t3.getName() != TokenName.OD) {
                // Syntax error!!!
                throw new SyntaxErrorException("od",t3);
            }
            ws = new WhileParseTree(e,s1);
            s = S(level);
            if (s instanceof EmptyParseTree) {
                return ws;
            } else {
                return new SCompParseTree(ws,s);
            }
        default:
            if (level == 0) {
                // Syntax error!!!
                throw new
                    SyntaxErrorException
                    ("a var or if or while or for or switch",t1);
            } else {
                idx--;
            }
            return new EmptyParseTree();
        }
    }
}
