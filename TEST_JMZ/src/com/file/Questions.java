package com.file;


public class Questions {
	
	private String qsn;
	private String oOne;
	private String oTwo;
	private String oThree;
	private String oFour;
	private String ans;
	
	

	 
	

	public Questions() {
		
	}



	
	@Override
	public String toString() {
		return "Questions [qsn=" + qsn + ", oOne=" + oOne + ", oTwo=" + oTwo + ", oThree=" + oThree + ", oFour=" + oFour
				+ ", ans=" + ans + "]";
	}




	public Questions(String qsn, String oOne, String oTwo, String oThree, String oFour, String ans) {
		super();
		this.qsn = qsn;
		this.oOne = oOne;
		this.oTwo = oTwo;
		this.oThree = oThree;
		this.oFour = oFour;
		this.ans = ans;
	}

	public String getQsn() {
		return qsn;
	}
	

	

	public void setQsn(String qsn) {
		this.qsn = qsn;
	}

	public String getoOne() {
		return oOne;
	}

	public void setoOne(String oOne) {
		this.oOne = oOne;
	}

	public String getoTwo() {
		return oTwo;
	}

	public void setoTwo(String oTwo) {
		this.oTwo = oTwo;
	}

	public String getoThree() {
		return oThree;
	}

	public void setoThree(String oThree) {
		this.oThree = oThree;
	}

	public String getoFour() {
		return oFour;
	}

	public void setoFour(String oFour) {
		this.oFour = oFour;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}
	
	

}
