package com.ynter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.ynter.pojo.BookInfoPojo;

/**
 * 图书信息表映射类
 * 
 * @author Ynter.H
 *
 */
public interface BookInfoMapper {

	/**
	 * 增加图书信息
	 * 
	 * @param bookInfo
	 *            - 图书信息
	 * @return 增加结果
	 */
	@SelectKey(statement = " SELECT REPLACE(UUID(),'-','')", keyProperty = "id", resultType = String.class, before = true)
	@Insert(" INSERT INTO t_book_info(id, name, author, isbn, price, in_time) VALUES(#{id}, #{name}, #{author}, #{isbn}, #{price}, now())")
	public int insert(BookInfoPojo bookInfo);

	/**
	 * 删除图书信息（根据ID）
	 * 
	 * @param id
	 *            - 图书信息ID
	 * @return 删除结果
	 */
	@Delete(" DELETE FROM t_book_info WHERE id = #{id}")
	public int delete(String id);

	/**
	 * 查询所有图书信息
	 * 
	 * @return 查询结果（图书信息列表）
	 */
	@Select(" SELECT * FROM t_book_info")
	@Results(id = "bookInfos", value = { @Result(property = "inTime", column = "in_time") })
	public List<BookInfoPojo> findAll();

	/**
	 * 修改图书信息
	 * 
	 * @param bookInfo
	 *            - 图书信息
	 * @return 修改结果
	 */
	@Update(" UPDATE t_book_info SET name = #{name}, author = #{author}, isbn = #{isbn}, price = #{price} WHERE id = #{id}")
	public int update(BookInfoPojo bookInfo);
}
