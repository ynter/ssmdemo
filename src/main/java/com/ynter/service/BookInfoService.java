package com.ynter.service;

import java.util.List;

import com.ynter.pojo.BookInfoPojo;

/**
 * 图书信息service接口
 * 
 * @author Ynter.H
 *
 */
public interface BookInfoService {

	/**
	 * 增加图书信息
	 * 
	 * @param bookInfo
	 *            - 图书信息
	 * @return 增加结果
	 */
	public int setBookInfo(BookInfoPojo bookInfo);

	/**
	 * 删除图书信息（根据ID）
	 * 
	 * @param id
	 *            - 图书信息ID
	 * @return 删除结果
	 */
	public int removeBookInfo(String id);

	/**
	 * 查询所有图书信息
	 * 
	 * @return 查询结果（图书信息列表）
	 */
	public List<BookInfoPojo> getBookInfos();

	/**
	 * 修改图书信息
	 * 
	 * @param bookInfo
	 *            - 图书信息
	 * @return 修改结果
	 */
	public int changeBookInfo(BookInfoPojo bookInfo);
}
