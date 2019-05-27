package com.ynter.pojo;

import java.util.Date;

import lombok.Data;

/**
 * 图书信息pojo类
 * 
 * @author Ynter.H
 *
 */
@Data
public class BookInfoPojo {

	private String id;
	private String name;
	private String author;
	private String isbn;
	private Float price;
	private Date inTime;

}
