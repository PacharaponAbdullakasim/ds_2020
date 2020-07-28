package th.ac.utcc.cpe.data_structures.tree;

/**
 *
 * @author Suparerk Manitpornsut
 */
public class BinaryTreeSubject {
    
    public static void main(String [] args) {
        Subject s1 = new Subject("NC252", "Data Structures", 3.0f);
        Subject s2 = new Subject("NC360", "Computer Networks", 3.0f);
        Subject s3 = new Subject("NC151", "Computer Programming", 3.0f);
        Subject s4 = new Subject("NC255", "Digital Design", 3.0f);
    
        BinaryTree<Subject> bst = new BinaryTree<>(new SubjectComparator());
        bst.insert(s1);
        bst.insert(s2);
        bst.insert(s3);
        bst.insert(s4);
        
        bst.inOrderTraversal();
    }
    
    
}
