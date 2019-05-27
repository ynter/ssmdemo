package com.ynter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ynter.mapper.BookInfoMapper;
import com.ynter.pojo.BookInfoPojo;
import com.ynter.service.BookInfoService;

/**
 * 图书信息service实现类
 * 
 * @author Ynter.H
 *
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class BookInfoServiceImpl implements BookInfoService {

	@Autowired
	private BookInfoMapper bookInfoMapper;

	@Override
	@Transactional()
	public int setBookInfo(BookInfoPojo bookInfo) {
		return bookInfoMapper.insert(bookInfo);
	}

	@Override
	@Transactional()
	public int removeBookInfo(String id) {
		return bookInfoMapper.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BookInfoPojo> getBookInfos() {
		return bookInfoMapper.findAll();
	}

	@Override
	@Transactional()
	public int changeBookInfo(BookInfoPojo bookInfo) {
		return bookInfoMapper.update(bookInfo);
	}

}
