package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {


	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > write");

		System.out.println(personVo);

		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);


		return "redirect:/phone/list";
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) { 
		System.out.println("PhoneController > list");


		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> pList = phoneDao.getPersonList();
		System.out.println(pList.toString());


		model.addAttribute("pList", pList);

	
		return "/WEB-INF/views/list.jsp";
	}

	@RequestMapping(value = "/updateForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateForm(@RequestParam("no") String no, Model model) { 
		System.out.println("PhoneController > updateForm");


		int id = Integer.parseInt(no);
		PhoneDao phoneDao = new PhoneDao();
		PersonVo pinfo = phoneDao.getPerson(id);

		
		model.addAttribute("pinfo", pinfo);

		return "/WEB-INF/views/updateForm.jsp";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > update");


		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(personVo);


		return "redirect:/phone/list";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController > delete");

		System.out.println(personVo);

		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);


		return "redirect:/phone/list";
	}

	@RequestMapping(value = "/phone/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("폼컨>롸이트 도킹");

		return "/WEB-INF/views/writeForm.jsp";
	}

	@RequestMapping(value = "/phone/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@RequestParam("name") String name, @RequestParam("hp") String hp,
			@RequestParam("company") String company) {
		System.out.println("롸이트");

		PersonVo personVo = new PersonVo(name, hp, company);
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);

		System.out.println(name + hp + company);
		return "";
	}
	/*
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String List(Model model) {
		System.out.println("폼컨>리스트 도킹");

		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList.toString());

		model.addAttribute("personList", personList);

		return "WEB-INF/views/list.jsp";
	}
	*/
}
