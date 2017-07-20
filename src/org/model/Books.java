package org.model;

import java.util.Date;

/**
 * Books entity. @author MyEclipse Persistence Tools
 */

public class Books implements java.io.Serializable {

	// Fields

	private Integer bookId;
	private Type type;
	private String bookname;
	private String bookwrite;
	private Date publishdate;
	private String bookintroduce;
	private String picture;
	private Float price;
	private Stock stock;
	private int booknumber;
	private byte[] picture2;

	// Constructors

	/** default constructor */
	public Books() {
	}

	/** minimal constructor */
	public Books(String bookname, String bookwrite) {
		this.bookname = bookname;
		this.bookwrite = bookwrite;
	}
	
	

	public Books(String bookname, String bookwrite, Type type) {
		super();
		this.bookname = bookname;
		this.bookwrite = bookwrite;
		this.type=type;
	}

	/** full constructor */
	public Books(Type type, String bookname, String bookwrite,
			Date publishdate, String bookintroduce, String picture,
			Float price, Stock stock) {
		this.type = type;
		this.bookname = bookname;
		this.bookwrite = bookwrite;
		this.publishdate = publishdate;
		this.bookintroduce = bookintroduce;
		this.picture = picture;
		this.price = price;
		this.stock = stock;
	}

	// Property accessors

	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookwrite() {
		return this.bookwrite;
	}

	public void setBookwrite(String bookwrite) {
		this.bookwrite = bookwrite;
	}

	public Date getPublishdate() {
		return this.publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	public String getBookintroduce() {
		return this.bookintroduce;
	}

	public void setBookintroduce(String bookintroduce) {
		this.bookintroduce = bookintroduce;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public int getBooknumber() {
		return booknumber;
	}

	public void setBooknumber(int booknumber) {
		this.booknumber = booknumber;
	}

	public byte[] getPicture2() {
		return picture2;
	}

	public void setPicture2(byte[] picture2) {
		this.picture2 = picture2;
	}


}