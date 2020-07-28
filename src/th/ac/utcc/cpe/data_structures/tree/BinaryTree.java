package th.ac.utcc.cpe.data_structures.tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Suparerk Manitpornsut
 * @param <T>
 */
public class BinaryTree<T extends Comparable<T>> implements Iterable<T>{
    Node<T> root;
    Comparator<T> comparator;
    
    public BinaryTree() {
        this.root = null;
        this.comparator = null;
    }
    
    public BinaryTree(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }
    
    private int compare(T x, T y) {
        return (comparator == null) ? x.compareTo(y) : comparator.compare(x, y);
    }
    
    public void insert(T data) {
        root = insert(root, data);
    }
    
    public Node<T> insert(Node<T> p, T data) {
        if(p == null) return new Node<T>(data);
        
        if(compare(data, p.data) == 0) return p;
        
        if(compare(data, p.data) < 0)
            p.leftChild = insert(p.leftChild, data);
        else
            p.rightChild = insert(p.rightChild, data);
        
        return p;
    }
    
    public boolean search(T toSearch) {
        return search(root, toSearch);
    }

    private boolean search(Node<T> p, T data) {
        if (p == null) {
            return false;
        } else if (compare(data, p.data) == 0) {
            return true;
        } else if (compare(data, p.data) < 0) {
            return search(p.leftChild, data);
        } else {
            return search(p.rightChild, data);
        }
    }
    
    public void delete(T data) {
        root = delete(root, data);
    }

    private Node<T> delete(Node<T> p, T data) {
        if (p == null) {
            throw new RuntimeException("cannot delete.");
        } else if (compare(data, p.data) < 0) {
            p.leftChild = delete(p.leftChild, data);
        } else if (compare(data, p.data) > 0) {
            p.rightChild = delete(p.rightChild, data);
        } else {
            if (p.leftChild == null) {
                return p.rightChild;
            } else if (p.rightChild == null) {
                return p.leftChild;
            } else {
                // get data from the rightmost node in the left subtree
                p.data = retrieveData(p.leftChild);
                // delete the rightmost node in the left subtree
                p.leftChild = delete(p.leftChild, p.data);
            }
        }
        return p;
    }

    private T retrieveData(Node<T> p) {
        while (p.rightChild != null) {
            p = p.rightChild;
        }

        return p.data;
    }
    
    public void inOrderTraversal() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node<T> node) {
        if (node != null) {
            inOrderHelper(node.leftChild);
            System.out.println(node);
            inOrderHelper(node.rightChild);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    
    class MyIterator implements Iterator<T> {

        Stack<Node<T>> stk = new Stack<>();

        public MyIterator() {
            if (root != null) {
                stk.push(root);
            }
        }

        @Override
        public boolean hasNext() {
            return !stk.isEmpty();
        }

        @Override
        public T next() {
            Node<T> current = stk.peek();
            if (current.leftChild != null) {
                stk.push(current.leftChild);
            } else {
                Node<T> tmp = stk.pop();
                while (tmp.rightChild == null) {
                    if (stk.isEmpty()) {
                        return current.data;
                    }
                    tmp = stk.pop();
                }
                stk.push(tmp.rightChild);
            }
            
            return current.data;
        }
    }
}
