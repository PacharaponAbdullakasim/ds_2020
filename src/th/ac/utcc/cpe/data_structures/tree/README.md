# Sample of Generics

คลาส Node ในตัวอย่างก่อนหน้านี้จำเป็นต้องระบุชนิดของข้อมูล แต่ตัวอย่างโค้ดด้านล่างนี้ กำหนดให้ชนิดของข้อมูลเป็น ```<T>``` หรือ Generic เพื่อเปิดโอกาสในระบุชนิดของข้อมูลตอนนำคลาส Node นี้ไปใช้ ทำให้เกิดความยืดหยุ่นของการใช้งาน

```
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
```
ส่วนคลาส BinaryTree ที่เป็นแบบ Generic สามารถสร้างได้ดังโค้ดด้านล่างนี้ เห็นได้ชัดว่า กำหนดให้ ```root``` เป็น ```Node<T>``` โดยที่ยังไม่ระบุว่า ```T``` เป็นชนิดอะไร โค้ดส่วนที่เหลือคล้ายคลึงกับที่มีในบทเรียนเรื่อง BinaryTree แต่เปลี่ยนจากการวนรอบ ```while``` มาใช้ Recursion แทน ได้แก่ เมธอด ```insert```, ```search``` และ ```delete``` และมีการสืบทอดจากอินเตอร์เฟส ```Iterable``` โดยใช้การทำงานของ Stack มาช่วยเก็บข้อมูลให้เป็นกลุ่มก้อน สามารถนำข้อมูลมาตรวจสอบได้ว่ายังมีอยู่หรือไม่ วนรอบได้ เป็นต้น

```
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
```

ก่อนการใช้งานคลาส Node สร้างคลาสที่ต้องการใช้เก็บข้อมูลใน Node ก่อนซึ่งโดยทั่วไป เป็นคลาสแบบ JavaBean เช่น คลาส Subject ดังนี้

```
public class Subject implements Comparable<Subject> {
    private String code;
    private String name;
    private float  units;
    
    public Subject(String code, String name, float units) {
        this.code = code;
        this.name = name;
        this.units = units;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnits() {
        return units;
    }

    public void setUnits(float units) {
        this.units = units;
    }
    
    @Override
    public String toString() {
        return code + " " + name + " " + units;
    }

    @Override
    public int compareTo(Subject s) {
        return this.code.compareTo(s.getCode());
    }   
}
```

สิ่งสำคัญในคลาส JavaBean ที่สร้างคือ การสร้างเมธอด compareTo เพื่อบอกวิธีการเปรียบเทียบค่าคีย์ของโหนด ในกรณีตัวอย่างข้างบนนี้ เป็นการนำ code ของ Subject มาเปรียบเทียบกันแบบสตริง ซึ่งหากสังเกต คลาส Subject นี้ได้ implements อินเตอร์เฟส Comparable เอาไว้ด้วย แต่หากต้องการสร้าง JavaBean โดยไม่ implements Comparable สามารถสร้างคลาสที่ implements Comparable ต่างหากได้ เช่น SubjectComparator ดังนี้

```
public class SubjectComparator implements Comparator<Subject> {

    @Override
    public int compare(Subject s1, Subject s2) {
        return s1.getCode().compareTo(s2.getCode());
    }
    
}
```
ตัวอย่างการนำ BinaryTree ที่เป็น Generics คือคลาส BinaryTreeSubject และ BinaryTreeInteger ดังนี้

```
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
```

```
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
```
