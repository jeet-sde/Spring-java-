package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.dao.RegisterDAO;
import com.VO.RegisterVO;


@Controller
public class RegController {

	@Autowired
	private RegisterDAO regDAO;

	@RequestMapping(value = "reg.html", method = RequestMethod.GET)
	public ModelAndView Load() {

		return new ModelAndView("Registration","RegVO", new RegisterVO());

	}

	@RequestMapping(value = "insert.html", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute RegisterVO RegVO) {

		regDAO.insert(RegVO);
		return new ModelAndView("redirect:search.html");

	}
	@RequestMapping(value = "search.html", method = RequestMethod.GET)
	public ModelAndView Search() {

		List searchList = regDAO.search();
		return new ModelAndView("Search", "List", searchList);

	}
	@RequestMapping(value="delete.html", method=RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute RegisterVO RegVO, @RequestParam int id) {
		RegVO.setId(id);
		regDAO.delete(RegVO);
		return new ModelAndView("redirect:search.html");
	}
	@RequestMapping(value="edit.html", method=RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute RegisterVO RegVO, @RequestParam int id) {
		RegVO.setId(id);
		List edit_List = regDAO.edit(RegVO);

		return new ModelAndView("Registration", "RegVO", edit_List.get(0));
	}
}