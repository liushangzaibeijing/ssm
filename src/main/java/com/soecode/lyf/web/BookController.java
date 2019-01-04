package com.soecode.lyf.web;

import java.sql.Statement;
import java.util.List;

import com.soecode.lyf.dao.BookMapper;
import com.soecode.lyf.entity.BookExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.executor.SimpleExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soecode.lyf.entity.Book;
import com.soecode.lyf.service.BookService;

@Controller
@RequestMapping("/book") // url:/模块/资源/{id}/细分 /seckill/list
public class BookController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookService bookService;

	@Autowired
	private BookMapper bookMapper;

	/*
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Book> list = bookService.getList();
		model.addAttribute("list", list);
		// list.jsp + model = ModelAndView
		return "list";// WEB-INF/jsp/"list".jsp
	}
     */

	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Integer bookId, Model model) {
	    if(StringUtils.isEmpty(bookId)){
	        return null;
        }

		Book book = bookService.getById(bookId);
		if (book == null) {
			return "forward:/book/list";
		}
		model.addAttribute("book", book);
		return "detail";
	}

	@RequestMapping(value = "/mapper", method = RequestMethod.GET)
	private String mapper() {

		//添加
		Book book = new Book();
		book.setAuthor("梁晓声");
		book.setName("知青");
		book.setDescption("70年代人上山下乡");
		book.setEvaluateNumber(9999);
		book.setPrice("25.86");
		book.setPublicationDate("1994-10-21");
		book.setPublisHouse("北京石榴庄出版社");
		book.setScore(9.5);

		bookMapper.insertSelective(book);

		//更新
		Book bookUpdate = new Book();
		bookUpdate.setName("今夜有暴风雪");
		bookUpdate.setId(book.getId());
		BookExample bookExample = new BookExample();
		bookExample.createCriteria().andIdEqualTo(book.getId());
		int rows = bookMapper.updateByExampleSelective(bookUpdate,bookExample);
		if(rows==1){
			logger.info("更新成功");
		}

		//删除
		rows = bookMapper.deleteByExample(bookExample);
		if(rows==1){
			logger.info("删除成功");
		}
		return "detail";
	}



}
