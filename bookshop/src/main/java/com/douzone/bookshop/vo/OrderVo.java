package com.douzone.bookshop.vo;

public class OrderVo {
	private String orderNo;
	private String name;
	private Long price;
	private String address;
	private Long memberNo;
	private Long no;
	/**
	 * @return the no
	 */
	public Long getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(Long no) {
		this.no = no;
	}
	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the memberNo
	 */
	public Long getMemberNo() {
		return memberNo;
	}
	/**
	 * @param memberNo the memberNo to set
	 */
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public void setMemberNo(String no) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
		return "OrderVo [orderNo=" + orderNo + ", name=" + name + ", price=" + price + ", address=" + address + "]";
	}
	
	
	
}
