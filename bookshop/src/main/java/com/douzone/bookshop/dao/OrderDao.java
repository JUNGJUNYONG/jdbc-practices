package com.douzone.bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.douzone.bookshop.vo.OrderBookVo;
import com.douzone.bookshop.vo.OrderVo;



public class OrderDao {
	
	
	
	
	public List<OrderBookVo> findBook(Long member) {
		List<OrderBookVo> result = new ArrayList<OrderBookVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			String sql = "select a.no,a.title,d.amount from book a, cart b, member c,orders_book d\r\n" + 
					"where b.book_no = a.no\r\n" + 
					"and b.no = c.no\r\n" + 
					"and a.no = d.book_no\r\n" + 
					"and c.no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,member);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Long bookNo = rs.getLong(1);
				String name = rs.getString(2);
				Long amount = rs.getLong(3);
				OrderBookVo vo2 = new OrderBookVo();
				vo2.setBookNo(bookNo);
				vo2.setBookTitle(name);
				vo2.setAmount(amount);
				result.add(vo2);
				
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	
	
	public List<OrderVo> findAll() {
		List<OrderVo> result = new ArrayList<OrderVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();

			String sql = "select a.oder_no,b.name,a.price,a.address,b.no from orders a, member b\r\n" + 
					"where a.member_no = b.no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			

			while (rs.next()) {
				String no = rs.getString(1);
				String name = rs.getString(2);
				Long price = rs.getLong(3);
				String address = rs.getString(4);
				Long memberNo = rs.getLong(5);
				OrderVo vo = new OrderVo();
				vo.setOrderNo(no);
				vo.setName(name);
				vo.setPrice(price);
				vo.setAddress(address);
				vo.setNo(memberNo);
				findBook(memberNo);
				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	
	public Boolean insert(OrderVo vo) {

		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into orders value(null,now(),?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, vo.getPrice());
			pstmt.setString(2, vo.getAddress());
			pstmt.setLong(3, vo.getMemberNo());
			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	

	
	

	public Boolean delete(OrderVo vo) {

		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "delete from ordres where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, vo.getNo());

			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/bookshop";
			conn = DriverManager.getConnection(url, "bookshop", "bookshop");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}

		return conn;
	}

}
