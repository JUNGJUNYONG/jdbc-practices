package com.douzone.bookshop.vo;

public class OrderBookVo {
	private Long amount;
	private Long bookNo;
	private Long orderNo;
	private String bookTitle;
	/**
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}
	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	/**
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	/**
	 * @return the bookNo
	 */
	public Long getBookNo() {
		return bookNo;
	}
	/**
	 * @param bookNo the bookNo to set
	 */
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	/**
	 * @return the orderNo
	 */
	public Long getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "OrderBookVo ["+bookNo+"(책번호)"+bookTitle+"    "+amount+"권 ]";
	}

}
