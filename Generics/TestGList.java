public class TestGList {
	public static void main(String[] args) {
		GList<String> l1 = new GNnList<String>("C++", new GNil<String>());
		l1.cons("Java");
		GList<String> l2 = new GNnList<String>("C", new GNil<String>());
		l2.cons("C#");
		GList<String> l3 = l1.append(l2);
		System.out.println(l3);

		GList<Double> l4 = new GNnList<Double>(1.41, new GNil<Double>());
		l4.cons(1.73).cons(2.43);
		GList<Double> l5 = l4.append(l4);
		System.out.println(l5);

		boolean b = (l1.getClass() == l4.getClass());
		System.out.println(b);
		System.out.println(l1.getClass());
		System.out.println(l4.getClass());

		// no warning
		GList l6 = l4;

		// warning; try to uncomment & compile
		// % javac -Xlint:unchecked TestGList.java
		// GList<Double> l7 = l6;
		// l4 = l6;

		GNnList<Double> l8 = new GNnList<Double>(2.44, new GNil<Double>());
		l4 = l8;

		// cannot compile; error
		// GNnList<Double> l9 = l3;
		// GNnList<Double> l9 = l4;

		// cannot compile; error
		// GNnList<double> l10;
	}
}