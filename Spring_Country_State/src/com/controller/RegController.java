package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RegDAO;
import com.model.CountryVO;

@Controller
public class RegController {

	@Autowired
	private RegDAO regDAO;
	
	@RequestMapping(value = "country.html", method = RequestMethod.GET)
	public ModelAndView Load() {

		return new ModelAndView("Country",
				"CountryVO", new CountryVO());

	}

	@RequestMapping(value = "insert.html", method = RequestMethod.POST)
	public ModelAndView Insert(@ModelAttribute CountryVO countryVO) {

		regDAO.Insert(countryVO);
		return new ModelAndView("redirect:/search_country.html");

	}

	@RequestMapping(value = "search_country.html", method = RequestMethod.GET)
	public ModelAndView Search() {

		List<?> searchList = regDAO.search();
		return new ModelAndView("Search_Country", "List", searchList);

	}
	
	

}
