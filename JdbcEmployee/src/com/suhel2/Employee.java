package com.suhel2;

public class Employee {
	
	
	private static int eId;
	private static String eName;
	private static int eAge;
	private static String eDesignation;
	private static int eSal;
	
	
	/*
	 * int min = 5; int max = 999; private double
	 * empid1=Math.random()*(max-min+1)+min; int empid=(int)empid1; eId=(int)empid1;
	 */
	
	private static int min = 5;
	private static int max = 100;
	private static double eId1 = Math.random() * (max-min+1) + min;
	
	
	
	public static int geteId() {
		return eId;
	}
	public static void seteId(int eId) {
		Employee.eId = (int)eId1;
	}
	public static String geteName() {
		return eName;
	}
	public static void seteName(String eName) {
		Employee.eName = eName;
	}
	public static int geteAge() {
		return eAge;
	}
	public static void seteAge(int eAge) {
		Employee.eAge = eAge;
	}
	public static String geteDesignation() {
		return eDesignation;
	}
	public static void seteDesignation(String eDesignation) {
		Employee.eDesignation = eDesignation;
	}
	public static int geteSal() {
		return eSal;
	}
	public static void seteSal(int eSal) {
		Employee.eSal = eSal;
	}
	public Employee(int eId, String eName, int eAge, String eDesignation, int eSal) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.eAge = eAge;
		this.eDesignation = eDesignation;
		this.eSal = eSal;
	}
	public Employee() {
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eAge=" + eAge + ", eDesignation=" + eDesignation
				+ ", eSal=" + eSal + "]";
	}
	

}
