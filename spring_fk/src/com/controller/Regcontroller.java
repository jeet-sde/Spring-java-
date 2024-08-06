package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.LoginDAO;
import com.DAO.RegDAO;
import com.VO.RegVO;
import com.VO.LoginVO;

@Controller
public class Regcontroller {

	@Autowired
	private RegDAO regDAO;

	@Autowired
	private LoginDAO loginDAO;

	@RequestMapping(value = "load.html", method = RequestMethod.GET)
	public ModelAndView load() {
		return new ModelAndView("Registration", "RegVO", new RegVO());
	}

	@RequestMapping(value = "insert.html", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute RegVO regVO) {

		LoginVO vo = regVO.getLoginVO();
		loginDAO.insert(vo);
		regDAO.insert(regVO);

		return new ModelAndView("redirect:search.html");

	}

	@RequestMapping(value = "search.html", method = RequestMethod.GET)
	public ModelAndView search() {

		List searchList = regDAO.searchh();
		return new ModelAndView("Search", "List", searchList);

	}

	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam int id) {

		List ls = regDAO.findById(id);
		RegVO regVO = (RegVO) ls.get(0);

		LoginVO loginVO = regVO.getLoginVO();

		regDAO.delete(regVO);
		loginDAO.delete(loginVO);

		return new ModelAndView("redirect:search.html");
	}
	
	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int id) {

		List ls = regDAO.findById(id);
		return new ModelAndView("Registration", "RegVO",ls.get(0));

	}

}