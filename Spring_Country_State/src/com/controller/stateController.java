package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RegDAO;
import com.dao.StateDAO;
import com.model.StateVO;

@Controller
public class stateController {
	
	@Autowired
	private RegDAO regDAO;
	@Autowired
	private StateDAO stateDAO;
	
	@RequestMapping(value = "state.html", method = RequestMethod.GET)
	public ModelAndView Load1() {
		
		List<?> ls=regDAO.search();

		return new ModelAndView("State",
				"StateVO", new StateVO()).addObject("countrylist", ls);

	}
	

	@RequestMapping(value = "stateinsert.html", method = RequestMethod.POST)
	public ModelAndView Insert1(@ModelAttribute StateVO stateVO) {

		stateDAO.Insert(stateVO);
		return new ModelAndView("redirect:/search_state.html");

	}

	@RequestMapping(value = "search_state.html", method = RequestMethod.GET)
	public ModelAndView Search1() {

		List<?> searchList = stateDAO.search();
		return new ModelAndView("Search_State", "List", searchList);

	}
	
}