package com.douzone.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookmall.vo.AuthorVo;

public class AuthorDao {
	boolean result = false;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs;

	public List<AuthorVo> findAll() {
		List<AuthorVo> result = new ArrayList<>();

		try {
			con = getConnection();

			String sql = "select no,name from author";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				System.out.println(no + ":" + name);
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
//		6.	 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	
	public Boolean delete(AuthorVo authorVo) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "delete from author where no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, authorVo.getNo());
			int count = pstmt.executeUpdate();

//		5.	성공여부
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
//		6.	 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}

	public Boolean insert(AuthorVo authorVo) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "insert into author values(null,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authorVo.getName());
			int count = pstmt.executeUpdate();

//		5.	성공여부
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
//		6.	 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return result;
	}
	
	public Boolean update(AuthorVo authorVo) {
		boolean result = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update author set name = ? where no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authorVo.getName());
			pstmt.setLong(2, authorVo.getNo());
			int count = pstmt.executeUpdate();

//		5.	성공여부
			result = count == 1;
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
//		6.	 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	

	private Connection getConnection() {
		Connection con = null;
		try {

//		JDBC Driver(Mysql) 로딩
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/webdb";
			con = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패" + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		return con;
	}

}
