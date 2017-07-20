package org.service.impl;

import org.dao.BooksDao;
import org.dao.StockDao;
import org.service.IBuyService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BuyService implements IBuyService {
	private StockDao stockDao;
	
	private BooksDao booksDao;
	
	
	
	

	public void setBooksDao(BooksDao booksDao) {
		this.booksDao = booksDao;
	}



	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}



	public boolean buyBook(int id,int number)throws Exception {
		if(booksDao.getidbooks(id)!=null&&stockDao.getBookStock(id)>0){
			stockDao.buyBooks(number, number);
			return true;
		}
		return false;
	}

}
