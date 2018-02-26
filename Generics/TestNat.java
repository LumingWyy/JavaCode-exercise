public class TestNat {
	public static void main(String[] args) {
		Zero zero = new Zero();
		NzNat one = new NzNat(zero);
		NzNat two = one.plus(one);
		NzNat three = two.plus(one);
		NzNat four = two.plus(two);
		System.out.println(zero);
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);
		System.out.println(three.plus(four));
		System.out.println(three.compareTo(four));
		System.out.println(four.compareTo(three));
		System.out.println(four.compareTo(four));
	}
}