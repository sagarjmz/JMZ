package Java_Classes;


public class User {
	@Override
	public String toString() {
		return "User [Id=" + empid + ",name=" + name + ",age=" + age + ", designation=" + designation + ", salary="
				+ salary + "]";
	}

	public User(String name, String age, String designation, int salary) {
		super();
		this.name = name;
		this.age = age;
//		System.out.println(age);
		this.designation = designation;
		this.salary = salary;
	}
	public User(int id,String name, String age, String designation, int salary) {
		super();
		this.empid=id;
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
	}

	User() {

	}

	int min = 200;
	int max = 400;
	private double empid1 = Math.random() * (max - min + 1) + min;
	public int empid = (int) empid1;
	public String name;
	private String designation;
	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	private String age;

	public int getEmpid() {
		// TODO Auto-generated method stub
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	public String getDesignation() {
		// TODO Auto-generated method stub
		return designation;
	}

}
