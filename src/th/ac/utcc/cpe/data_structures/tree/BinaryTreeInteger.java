package th.ac.utcc.cpe.data_structures.tree;

/**
 *
 * @author Suparerk Manitpornsut
 */
public class BinaryTreeInteger {
    public static void main(String [] args) {
        Integer [] data = {5, 3, 2, 6, 4, 1, 9, 7};
        BinaryTree<Integer> bst = new BinaryTree<>(new IntegerComparator());
        
        for(Integer d : data) {
            bst.insert(d);
        }
        
        bst.inOrderTraversal();
    }
}
