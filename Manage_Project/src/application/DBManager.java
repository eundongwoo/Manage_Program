package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBManager {
	
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String user="hr";
	private String pwd="1234";
	Connection con;
	List<Integer> list=new ArrayList<>(); //회원 테이블에 있는 eno를 담는 리스트
	List<Worker> worker_list=new ArrayList<Worker>(); //회원을 담는 리스트
	
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
	
	//관리자가 아닌 회원들의 eno를 얻는 메서드
	public List<Integer> take_eno()
	{
		String sql="select eno from worker where position <> '관리자'";
		
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				list.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Worker> take_worker()
	{
		String sql="select eno,ename,gender,salary,position,hiredate,dname from worker natural join dept where position not like '%관리자%'";
		try {
			String name,gender,position,dname;
			int eno,salary;
			Date hiredate;
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				eno=rs.getInt(1);
				name=rs.getString(2);
				gender=rs.getString(3);
				salary=rs.getInt(4);
				position=rs.getString(5);
				hiredate=rs.getDate(6);
				dname=rs.getString(7);
				System.out.println(eno+"\t"+name+"\t"+gender+"\t"+salary+"\t"+position+"\t"+hiredate+"\t"+dname+"\t");
				
				Worker worker=new Worker(eno, name, gender, salary, position, hiredate, dname);
				worker_list.add(worker);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return worker_list;
	}
	
	public void worker_delete(int eno)
	{
		String sql="delete from worker where eno=?";
		try {
			PreparedStatement prst=con.prepareStatement(sql);
			prst.setInt(1, eno);
			prst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Register_insert(Worker worker) {
		String sql = "insert into worker(eno, password, ename, position, dno) VALUES(worker_aaa.NEXTVAL, ?,?, '관리자', 3)";
		try {
			PreparedStatement prst=con.prepareStatement(sql);
			prst.setInt(1, Integer.parseInt(worker.getPassword()));
			prst.setString(2, worker.getName());
			prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void job_update(String condition, String newData, String dno) {
		String sql = "update dept set " + condition +"=? where dno =?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			if(condition.equals("dname")) {
				prst.setString(1, newData);
				prst.setString(2, dno);
				prst.executeUpdate();
			}else {
				prst.setString(1, newData);
				prst.setString(2, dno);
				prst.executeUpdate();
			}
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
	public void change_check(String id,int pwd)
	{
		String sql="update worker set state=? where eno=? and password=?";
		try {
			PreparedStatement prst=con.prepareStatement(sql);
			prst.setString(1, "1");
			prst.setInt(2, Integer.parseInt(id));
			prst.setInt(3, pwd);
			prst.executeUpdate();
			System.out.println("로그인!!!!! 상태 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String user_name()
	{
		String sql="select ename from worker where state='1'";
		String str=null;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next())
			{
				str=rs.getString(1);
			}
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}
	
	public void logout()
	{
		String sql="update worker set state=0 where state=1";
		try {
			Statement st=con.createStatement();
			st.executeUpdate(sql);
			System.out.println("로그아웃 완료!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void job_insert(Job job) {
		String sql = "insert into dept VALUES(dept_aaa.NEXTVAL,?, ?)";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, job.getDname());
			prst.setString(2, job.getLocation());
			prst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
