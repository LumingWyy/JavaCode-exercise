import java.util.regex.*;

public class SourceCode {
    private String sourceCode;

    public SourceCode(String sc) {
        sourceCode = sc;
    }

    private Token toToken(String s) {
        if (s.equals("if")) {
            return new Token(TokenName.IF);
        } else if (s.equals("then")) {
            return new Token(TokenName.THEN);
        } else if (s.equals("else")) {
            return new Token(TokenName.ELSE);
        } else if (s.equals("fi")) {
            return new Token(TokenName.FI);
        } else if (s.equals("while")) {
            return new Token(TokenName.WHILE);
        } else if (s.equals("do")) {
            return new Token(TokenName.DO);
        } else if (s.equals("od")) {
            return new Token(TokenName.OD);
        } else if (s.equals("default")) {
            return new Token(TokenName.DEFAULT);
        } else {
            if (Pattern.matches("[0-9]+",s)) {
                return new Token(TokenName.NUM,
                                 Integer.parseInt(s,10));
            } else if (Pattern.matches("[a-zA-Z][0-9a-zA-Z]*",s)) {
                return new Token(TokenName.VAR,s);
            } else {
                return new Token(TokenName.UNDEF,s);
            }
        }
    }

    public TokenList scan() {
        TokenList tl = new TokenList();
        String str = "";
        Token t;
        Character c, c1;
        int idx = 0;

        while (idx < sourceCode.length()) {
            c = sourceCode.charAt(idx++);
            if (Character.isWhitespace(c)) {
                if (str.length() != 0) {
                    tl.add(toToken(str));
                    str = "";
                }
                continue;
            }
            switch (c) {
            case ';':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.SEMC));
                break;
            case '(':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.LPAR));
                break;
            case ')':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.RPAR));
                break;
            case '*':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.MUL));
                break;
            case '/':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.QUO));
                break;
            case '%':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.REM));
                break;
            case '+':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.PLUS));
                break;
            case '-':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.MINUS));
                break;
            case '<':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.LT));
                break;
            case '>':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.GT));
                break;
            case '=':
                if (str.length() != 0) {
                 tl.add(toToken(str));
                    str = "";
                }
                tl.add(new Token(TokenName.EQ));
                break;
            case '!':
                if (idx == sourceCode.length()) {
                    str = str + c;
                } else if (sourceCode.charAt(idx) == '=') {
                    if (str.length() != 0) {
                        tl.add(toToken(str));
                        str = "";
                    }
                    tl.add(new Token(TokenName.NEQ));
                    idx++;
                } else {
                    str = str + c;
                }
                break;
            case '&':
                if (idx == sourceCode.length()) {
                    str = str + c;
                } else if (sourceCode.charAt(idx) == '&') {
                    if (str.length() != 0) {
                        tl.add(toToken(str));
                        str = "";
                    }
                    tl.add(new Token(TokenName.AND));
                    idx++;
                } else {
                    str = str + c;
                }
                break;
            case '|':
                if (idx == sourceCode.length()) {
                    str = str + c;
                } else if (sourceCode.charAt(idx) == '|') {
                    if (str.length() != 0) {
                        tl.add(toToken(str));
                        str = "";
                    }
                    tl.add(new Token(TokenName.OR));
                    idx++;
                } else {
                    str = str + c;
                }
                break;
            case ':':
                if (idx == sourceCode.length()) {
                    str = str + c;
                    break;
                }
                if (sourceCode.charAt(idx) == '=') {
                    if (str.length() != 0) {
                        tl.add(toToken(str));
                        str = "";
                    }
                    tl.add(new Token(TokenName.ASSIGN));
                    idx++;
                } else {
                    str = str + c;
                }
                break;
            default:
                str = str + c;
            }
        }
        if (str.length() != 0) {
            tl.add(toToken(str));
            str = "";
        }
        return tl;
    }

    public String toString() {
        return sourceCode;
    }
}