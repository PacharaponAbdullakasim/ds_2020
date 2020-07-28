# Sample of Generics

คลาส Node ในตัวอย่างก่อนหน้านี้จำเป็นต้องระบุชนิดของข้อมูล แต่ตัวอย่างโค้ดด้านล่างนี้ ให้ชนิดของข้อมูลเป็น Generic เพื่อเปิดโอกาสในระบุชนิดของข้อมูลตอนนำคลาส Node นี้ไปใช้ ทำให้เกิดความยืดหยุ่นของการใช้งาน

`
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
`
