public class Token {
	private TokenName name;
	private int num;
	private String undef;

	public Token(TokenName n) {
		name = n;
	}

	public Token(TokenName n, int x) {
		name = n;
		num = x;
	}

	public Token(TokenName n, String s) {
		name = n;
		undef = s;
	}

	public TokenName getName() {
		return name;
	}

	public int getNum() {
		return num;
	}

	public String getUndef() {
		return undef;
	}

	public String toString() throws IllegalStateException {
		switch (name) {
		case LPAR:
			return "(";
		case RPAR:
			return ")";
		case MUL:
			return "*";
		case QUO:
			return "/";
		case REM:
			return "%";
		case PLUS:
			return "+";
		case MINUS:
			return "-";
		case NUM:
			return "num=" + num;
		case UNDEF:
			return "undef: " + undef;
		default:
			// You never get here!
			throw new IllegalStateException("token(" + num + "," + undef + ")");
		}
	}
}
