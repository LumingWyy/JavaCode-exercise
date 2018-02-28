import java.util.*;
/* name: Wang Luming

 * */

public class NzNat implements Nat {
	private Nat n;

	public NzNat(Nat y) {
		this.n = y;
	}

	public Nat pred() {
		return n;
	}

	public NzNat plus(Nat y) {
		return new NzNat(n.plus(y));
	}

	public int compareTo(Nat y) {
		if ((y instanceof Zero)) {
			return 1;
		}
		return n.compareTo(((NzNat) y).pred());
	}

	public String toString() {
		return "s(" + n + ")";
	}
}
