public class PrimitiveWrapperClass {
	public static void main(String[] args) {
		int four = new Integer("4");
		Integer five = 5;
		Integer six = new Integer(6);
		int x = 3 + four;
		int y = four + five + six;
		System.out.println(four);
		System.out.println(five);
		System.out.println(six);
		System.out.println(x);
		System.out.println(y);
		// cannot be compiled!!!
		// four = null;

		// can be compiled
		five = null;
		System.out.println(five);
	}
}