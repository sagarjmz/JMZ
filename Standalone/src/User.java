

import java.util.Random;

public class User {

//	public User(String name, String designation, int salary, int age) {
//		super();
//		Random r = new Random();
//		int ui = r.nextInt(1000);
//		 this.uid = String.valueOf(ui);
//		this.name = name;
//		this.designation = designation;
//		this.salary = salary;
//		this.age = age;
//	}

	public User(String name, String designation, long salary, long uid, int age) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.uid = uid;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", designation=" + designation + ", salary=" + salary + ", age="
				+ age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public User(String name, String designation, long salary, int age) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.age = age;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User() {

	}

	private String name;
	private String designation;
	private long salary;
	private long uid;
	private int age;

}
