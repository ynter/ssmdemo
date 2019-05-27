package com.ynter.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ynter.pojo.BookInfoPojo;
import com.ynter.service.BookInfoService;

/**
 * 图书信息controller类
 * 
 * @author Ynter.H
 *
 */
@Controller
@RequestMapping("/bookInfo")
public class BookInfoController {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	private BookInfoService bookInfoService;

	/**
	 * 增加图书信息
	 * 
	 * @param request
	 *            - 页面request
	 * @return 展示页面
	 */
	@RequestMapping("/createBookInfo")
	public ModelAndView createBookInfo(HttpServletRequest request) {

		BookInfoPojo bookInfo = new BookInfoPojo();

		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		Float price = Float.valueOf(request.getParameter("price"));

		bookInfo.setName(name);
		bookInfo.setAuthor(author);
		bookInfo.setIsbn(isbn);
		bookInfo.setPrice(price);

		int result = bookInfoService.setBookInfo(bookInfo);

		log.info("The insert result is : " + (result > 0 ? true : false));

		return showBookInfos(request);
	}

	/**
	 * 删除图书信息
	 * 
	 * @param request
	 *            - 页面request
	 * @return 展示页面
	 */
	@RequestMapping("/destroyBookInfo")
	public ModelAndView destroyBookInfo(HttpServletRequest request) {

		String id = request.getParameter("id");

		int result = bookInfoService.removeBookInfo(id);

		log.info("The delete result is : " + (result > 0 ? true : false));

		return showBookInfos(request);
	}

	/**
	 * 展示图书信息
	 * 
	 * @param request
	 *            - 页面request
	 * @return 展示页面
	 */
	@RequestMapping("/showBookInfos")
	public ModelAndView showBookInfos(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("bookInfo/showBookInfos");
		mv.addObject("bookInfos", bookInfoService.getBookInfos());

		return mv;
	}

	/**
	 * 修改图书信息
	 * 
	 * @param request
	 *            - 页面request
	 * @return 展示页面
	 */
	@RequestMapping("/modifyBookInfo")
	public ModelAndView modifyBookInfo(HttpServletRequest request) {

		BookInfoPojo bookInfo = new BookInfoPojo();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String isbn = request.getParameter("isbn");
		Float price = Float.valueOf(request.getParameter("price"));

		bookInfo.setId(id);
		bookInfo.setName(name);
		bookInfo.setAuthor(author);
		bookInfo.setIsbn(isbn);
		bookInfo.setPrice(price);

		int result = bookInfoService.changeBookInfo(bookInfo);

		log.info("The update result is : " + (result > 0 ? true : false));

		return showBookInfos(request);
	}
}
