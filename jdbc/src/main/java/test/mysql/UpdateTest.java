package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {


	
	
	public static boolean update(DeptVo vo) {
		Connection conn = null;
		Statement stmt = null;
		boolean result =  false;
		
		if(result) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		try {
//		JDBC Driver(Mysql) 로딩
			Class.forName("com.mysql.jdbc.Driver");
//		2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
//		3.	Statement 객체생성
			stmt = conn.createStatement();
//		4.  SQL문 실행
			String sql = "update dept set name='"+vo.getName()+"'where no = "+vo.getNo();
			int count = stmt.executeUpdate(sql);
			
//		5.	성공여부
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패"+e);
		} catch (SQLException e) {
			System.out.println("error:"+e);
		}finally {
//		6.	 자원정리
			try {
				if(stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
		return result;
		
	}
	
	public static void main(String[] args) {
		DeptVo vo = new DeptVo();
		vo.setNo(5L);
		vo.setName("기획운영팀");
		
		Boolean result = update(vo);
		
		if(result) {
			System.out.println("성공");
		}

	}

}
