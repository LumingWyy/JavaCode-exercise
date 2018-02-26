public class TestTBST2 {
    public static void main(String[] args) {
        TentativeBinarySearchTree<Nat,String> oopls1;

        // cannot be compiled!!!
        // because NzNat is out of the bounds of K that is
        // declared as "K extends Comparable<K>" in
        // TentativeBinarySearchTree
        //
        // TentativeBinarySearchTree<NzNat,String> oopls2;
    }
}