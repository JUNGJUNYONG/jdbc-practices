package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
	public Boolean insert(EmployeeVo vo) {
		return false;
	}
	
	public Boolean delete(Long no) {
		return false;
	}
	
	public Boolean insert(String firstName) {
		return false;
	}
	
	public Boolean pdate(EmployeeVo vo) {
		return false;
	}
	
	public List<EmployeeVo> findByName(EmployeeVo vo){
		List<EmployeeVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		try {
//		JDBC Driver(Mysql) 로딩
			Class.forName("com.mysql.jdbc.Driver");
//		2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/employees";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			System.out.println("연결성공");
//		3.	SQL문 준비(Prepare, 완성된 쿼리가 아님)
			String sql = "select emp_no, first_name, last_name, hire_date\r\n" + 
					" from employees\r\n" + 
					" where first_name like ?" + 
					" order by first_name";
			pstmt = conn.prepareStatement(sql);
//		4.	바인딩
			pstmt.setString(1, "%"+vo.getFirstName()+"%");
			
			
//		5.  SQL문 실행
			rs = pstmt.executeQuery();
			
//		6.	결과 바인딩
			while(rs.next()) {
				Long no = rs.getLong(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				String hireDate = rs.getString(4);
				
				EmployeeVo employeeVo = new EmployeeVo();
				employeeVo.setNo(no);
				employeeVo.setFirstName(firstName);
				employeeVo.setLastName(lastName);
				employeeVo.setHireDate(hireDate);
				
				result.add(employeeVo);
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
		return result;
	}
	

}
