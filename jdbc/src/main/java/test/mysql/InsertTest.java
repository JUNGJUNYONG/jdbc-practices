package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {

	public static void main(String[] args) {
		boolean result = insert("기획팀");
		if(result) {
			System.out.println("성공");
		}
	}

	public static boolean insert(String name) {
		boolean result = false;
		Connection con = null;
		Statement stmt = null;
		try {

//		JDBC Driver(Mysql) 로딩
			Class.forName("com.mysql.jdbc.Driver");
//		2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			con = DriverManager.getConnection(url, "webdb", "webdb");

			System.out.println("연결성공");
//		3.	Statement 객체생성
			stmt = con.createStatement();
//		4.  SQL문 실행
			String sql = "insert into dept values(null,'디자인팀')";
			int count = stmt.executeUpdate(sql);

//		5.	성공여부
			result = count == 1;
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
//		6.	 자원정리
			try {
				if(stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
			}

		}

		return result;
	}

}
