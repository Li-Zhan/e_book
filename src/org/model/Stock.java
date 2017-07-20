package org.model;

/**
 * Stock entity. @author MyEclipse Persistence Tools
 */

public class Stock implements java.io.Serializable {

	// Fields

	private Integer stockId;
	private Books books;
	private Integer stockQty;

	// Constructors

	/** default constructor */
	public Stock() {
	}
	
	

	public Stock(Integer stockQty) {
		super();
		this.stockQty = stockQty;
	}



	/** full constructor */
	public Stock(Integer stockId, Integer stockQty) {
		this.stockId =stockId;
		this.stockQty = stockQty;
	}
	

	public Stock(Integer stockId, Books books, Integer stockQty) {
		super();
		this.stockId = stockId;
		this.books = books;
		this.stockQty = stockQty;
	}

	// Property accessors


	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public Books getBooks() {
		return this.books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public Integer getStockQty() {
		return this.stockQty;
	}

	public void setStockQty(Integer stockQty) {
		this.stockQty = stockQty;
	}

}