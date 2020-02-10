package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs;
		try {
//		JDBC Driver(Mysql) 로딩
			Class.forName("com.mysql.jdbc.Driver");
//		2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			System.out.println("연결성공");
//		3.	Statement 객체생성
			stmt = conn.createStatement();
//		4.  SQL문 실행
			String sql = "select no,name from dept";
			rs = stmt.executeQuery(sql);
			
//		5.	결과 가져오기
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				System.out.println(no+":"+name);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패"+e);
		} catch (SQLException e) {
			System.out.println("error:"+e);
		}finally {
//		6.	 자원정리
			try {
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException e){
			}
		}

	}

}
