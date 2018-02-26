public class TestBST {
	public static void main(String[] args) {
		NzNat one = new NzNat(new Zero());
		NzNat two = new NzNat(one);
		NzNat three = new NzNat(two);
		NzNat four = new NzNat(three);
		NzNat five = new NzNat(four);
		NzNat six = new NzNat(five);
		NzNat seven = new NzNat(six);
		BinarySearchTree<NzNat, String> oopls = new BinarySearchTree<NzNat, String>();
		oopls.put(four, "ABCL/1");
		oopls.put(two, "Smalltalk-80");
		oopls.put(six, "Self");
		oopls.put(one, "Simula 67");
		oopls.put(three, "CLOS");
		oopls.put(five, "C++");
		oopls.put(seven, "Java");
		System.out.println("2: " + oopls.get(two));
		System.out.println("7: " + oopls.get(seven));
		System.out.println(oopls);
	}
}