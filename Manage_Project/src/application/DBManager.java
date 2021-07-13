package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
	//직원 등록 코드
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
	//직원 수정 코드
	public void worker_update(String condition,String newData,String eno)
	{
		String sql="update worker set "+condition+"= ? where eno=?";
		try {
				if(condition.equals("dno"))
				{
					PreparedStatement prst=con.prepareStatement(sql);
					prst.setInt(1, Integer.parseInt(newData));
					prst.setInt(2, Integer.parseInt(eno));
					prst.executeUpdate();
					
				}else
				{
					PreparedStatement prst=con.prepareStatement(sql);
					prst.setString(1, newData);
					prst.setInt(2, Integer.parseInt(eno));
					prst.executeUpdate();
					
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Register_insert(Worker worker) {
		String sql = "insert into worker(eno, password, ename, position, dno) VALUES(worker_aaa.NEXTVAL, ?,?, ?, 2)";
		try {
			PreparedStatement prst=con.prepareStatement(sql);
			prst.setInt(1, Integer.parseInt(worker.getPassword()));
			prst.setString(2, worker.getName());
			prst.setString(3, worker.getPosition());
			prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int Login(Worker worker) {
		int pass=0;
		String sql = "select password from worker where eno = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setInt(1, Integer.parseInt(worker.getID()));
			ResultSet rs = prst.executeQuery();
			if(rs.next()) {	
				pass = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return pass;
	}

	
}
