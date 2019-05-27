package com.ynter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.ynter.base.BaseTest;
import com.ynter.mapper.BookInfoMapper;
import com.ynter.pojo.BookInfoPojo;

/**
 * 图书信息测试类（针对service）
 * 
 * @author Ynter.H
 *
 */
public class BookInfoServiceTest extends BaseTest {

	@Autowired
	private BookInfoMapper bookInfoMapper;

	/**
	 * 测试增加图书信息
	 */
	@Test
	@Transactional
	@Rollback(true)
	public void setBookInfo() {
		BookInfoPojo bookInfo = new BookInfoPojo();
		bookInfo.setName("测试");
		bookInfo.setAuthor("测试");
		bookInfo.setIsbn("xxx-xxxxx-xx-xx-x");
		bookInfo.setPrice(38.9F);

		int result = bookInfoMapper.insert(bookInfo);

		assertEquals(result, 1);
	}

	/**
	 * 测试查询图书信息
	 */
	@Test
	@Transactional(readOnly = true)
	public void getBookInfo() {
		List<BookInfoPojo> bookInfos = bookInfoMapper.findAll();
		System.out.println(bookInfos);

		assertNotNull(bookInfos);
	}

	/**
	 * 测试修改图书信息
	 */
	@Test
	@Transactional
	@Rollback(true)
	public void changeBookInfo() {
		BookInfoPojo bookInfo = new BookInfoPojo();
		bookInfo.setId("5379219867c811e99b563c970edafadc");
		bookInfo.setName("测试2");
		bookInfo.setAuthor("测试2");
		bookInfo.setIsbn("xxx-xxxxx-xx-xx-x");
		bookInfo.setPrice(55.0F);

		int result = bookInfoMapper.update(bookInfo);

		assertEquals(result, 1);
	}

	/**
	 * 测试删除图书信息
	 */
	@Test
	@Transactional
	@Rollback(true)
	public void removeBookInfo() {
		int result = bookInfoMapper.delete("5379219867c811e99b563c970edafadc");

		assertEquals(result, 1);
	}
}
