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
