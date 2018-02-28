import java.util.*;
/* name: Wang Luming

 * */

public class Zero implements Nat {
	public Nat plus(Nat y) {
		return y;
	}

	public int compareTo(Nat y) {
		if ((y instanceof Zero)) {
			return 0;
		}
		return -1;
	}

	public String toString() {
		return "0";
	}
}
