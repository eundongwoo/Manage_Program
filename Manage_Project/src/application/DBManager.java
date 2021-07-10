package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user="hr";
	private String pwd="1234";
	static Connection con;
	
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
	
	
}
