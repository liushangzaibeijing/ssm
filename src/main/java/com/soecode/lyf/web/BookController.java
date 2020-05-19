package com.soecode.lyf.web;


import com.soecode.lyf.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.soecode.lyf.entity.Book;

@Controller
@RequestMapping("/book") // url:/模块/资源/{id}/细分 /seckill/list
public class BookController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DemoService demoService;


	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Integer bookId, Model model) {
		if (StringUtils.isEmpty(bookId)) {
			return null;
		}
		Book book = demoService.getById(bookId);
		if (book == null) {
			return "forward:/book/list";
		}
		model.addAttribute("book", book);
		return "detail";
	}
}