package application;

import java.sql.Date;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

public class WorkerTableRowData {
	private StringProperty name,gender,position,dname;
	private IntegerProperty salary,eno;
	private ObjectProperty<Date> hiredate;
	
	public WorkerTableRowData(IntegerProperty eno,StringProperty name, StringProperty gender,IntegerProperty salary,StringProperty position,
			  ObjectProperty<Date> hiredate,StringProperty dname) {
		
		this.name = name;
		this.gender = gender;
		this.position = position;
		this.dname = dname;
		this.salary = salary;
		this.eno = eno;
		this.hiredate = hiredate;
	}

	public StringProperty getName() {
		return name;
	}

	public StringProperty getGender() {
		return gender;
	}

	public StringProperty getPosition() {
		return position;
	}

	public StringProperty getDname() {
		return dname;
	}

	public IntegerProperty getSalary() {
		return salary;
	}

	public IntegerProperty getEno() {
		return eno;
	}

	public ObjectProperty<Date> getHiredate() {
		return hiredate;
	}	 
}
