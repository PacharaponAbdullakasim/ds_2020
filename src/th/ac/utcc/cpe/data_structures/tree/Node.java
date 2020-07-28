package th.ac.utcc.cpe.data_structures.tree;

/**
 *
 * @author Suparerk Manitpornsut
 */
public class Node<T> {
    T data;
    Node<T> leftChild;
    Node<T> rightChild;
    
    public Node(T data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return data.toString();
    }
}
