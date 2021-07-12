package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManager {
	
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user="hr";
	private String pwd="1234";
	Connection con;
	
	public DBManager() {
		// TODO Auto-generated constructor stub
		 
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("로딩완료");
			con=DriverManager.getConnection(url, user, pwd);
			System.out.println("디비연결:"+con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void worker_insert(Worker worker)
	{
		String sql="insert into worker(eno,ename,gender,salary,position,hiredate,dno) values(worker_aaa.NEXTVAL,?,?,?,?,?,?)";
		try {
			PreparedStatement prst=con.prepareStatement(sql);
			prst.setString(1, worker.getName());
			prst.setString(2, worker.getGender());
			prst.setInt(3, worker.getSalary());
			prst.setString(4, worker.getPosition());
			prst.setDate(5, worker.getHiredate());
			prst.setString(6, worker.getDno());
			prst.executeUpdate();
			System.out.println("등록되었습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
