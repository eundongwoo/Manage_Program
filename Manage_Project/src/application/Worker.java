package application;


import java.sql.Date;
import java.time.LocalDate;


public class Worker {

	private String name,gender,position,dno,password;
	private int salary;
	private Date hiredate;
	
	public Worker() {
		// TODO Auto-generated constructor stub
	}
	

	public Worker(String name, String gender, int salary,String position,Date hiredate, String dno) {
		this.name = name;
		this.gender = gender;
		this.position = position;
		this.dno = dno;
		this.salary = salary;
		this.hiredate = hiredate;
	}
	public Worker(String password,String name, String position) {
		this.name = name;
		this.position = position;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
}
