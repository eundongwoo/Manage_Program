package application;

public class Job {
	private String dno, dname, location;
	
	public Job(String dno, String dname, String location) {
		super();
		this.dno = dno;
		this.dname = dname;
		this.location = location;
	}
	public Job(String dname, String location) {
		super();
	
		this.dname = dname;
		this.location = location;
	}
	

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
