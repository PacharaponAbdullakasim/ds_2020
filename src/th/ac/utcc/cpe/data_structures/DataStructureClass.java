package th.ac.utcc.cpe.data_structures;

public class DataStructureClass {
	private int size;
	private int count;
	private StudentRecord [] listOfStudents;
	
	public DataStructureClass(int size) {		
		if(size <= 0) {
			size = 10;
		}
		this.size = size;
		this.listOfStudents = new StudentRecord[size];
		this.count = 0;
	}
	
	//C => Create
	public void insert(StudentRecord s) {
		if(count != size) {
			this.listOfStudents[count] = s;
			count++;
		}
	}
	
	//R => Retrieve
	public String toString() {
		String s = "";
		for(int i=0; i < count;i++) {
			s += this.listOfStudents[i].getId() + "," + this.listOfStudents[i].getName() + 
					"," + this.listOfStudents[i].getEmail() + "," + 
					this.listOfStudents[i].getPhone() + "\n";
		}
		
		return s;
	}
	
	//U => Update
	public void update(int index, StudentRecord newRecord) {
		// index > size
		// index > count
		this.listOfStudents[index] = newRecord;
	}
	
	public void updateName(int index, String newName) {
		this.listOfStudents[index].setName(newName);
	}
	
	public void updateId(int index, long newId) {
		this.listOfStudents[index].setId(newId);
	}
	
	//D => Delete
	public void delete(int index) {
		if(index < size && index >= 0) {
			for(int i = index; i < count; i++) {
				this.listOfStudents[i] = this.listOfStudents[i + 1];
			}
			count--;
		}
	}
	
	public int length() {
		return count;
	}
	
	public boolean isFull() {
		return count == size;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public void toyMethod() {
		for(int i = 0; i < count; i++) {

		}
		
		for(int j=0; j < count; j++) {
			String x = this.listOfStudents[j].getEmail();
			System.out.println(x);
		}
	}

	public static void main(String[] args) {
		int size = 5;
		DataStructureClass myClass = new DataStructureClass(size);
		
		StudentRecord s1 = new StudentRecord();
		s1.setId(1);
		s1.setName("James");
		s1.setEmail("james@mail.com");
		s1.setPhone("1234567");
		myClass.insert(s1);
		
		StudentRecord s2 = new StudentRecord();
		s2.setId(2);
		s2.setName("John");
		s2.setEmail("john@mail.com");
		s2.setPhone("7654321");
		myClass.insert(s2);
		
		System.out.println("My students: \n" + myClass);
		myClass.toyMethod();
		
		myClass.delete(0);
		System.out.println("My students: \n" + myClass);
		
		for(int i = 0; i < 5; i++) {
			StudentRecord s = new StudentRecord();
			myClass.insert(s);
		}
		
	}

}
