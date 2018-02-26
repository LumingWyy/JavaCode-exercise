public class TestTBST {
    public static void main(String[] args) {
        /*
        // int cannot be used here!!!
        TentativeBinarySearchTree<Integer,String> oopls
            = new TentativeBinarySearchTree<int,String>();
        */
        TentativeBinarySearchTree<Integer,String> oopls
            = new TentativeBinarySearchTree<Integer,String>();
        oopls.put(4,"ABCL/1");
        oopls.put(2,"Smalltalk-80");
        oopls.put(6,"Self");
        oopls.put(1,"Simula 67");
        oopls.put(3,"CLOS");
        oopls.put(5,"C++");
        oopls.put(7,"Java");
        System.out.println("2: " + oopls.get(2));
        System.out.println("7: " + oopls.get(7));
        System.out.println(oopls);

        // compilation error b/c System does not implement
        // Comparable<System>
        // TentativeBinarySearchTree<System,String> tbst;
    }
}