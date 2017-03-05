package com.kse.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kse.service.Semeval2010Service;

@Controller
public class SemEval2010 {

	Semeval2010Service semeval2010Service;

	@Autowired
	public void setSemeval2010Service(Semeval2010Service semeval2010Service) {
		this.semeval2010Service = semeval2010Service;
	}

	@RequestMapping("/")
	public String instance() {
		return "semeval2010";
	}

	@RequestMapping(value = "/getonedoc.do")
	public @ResponseBody Map getOneDoc(@RequestBody Map map) {
		try {
			return semeval2010Service.getOneDoc(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/crowdone.do")
	public @ResponseBody Map crowdOne(@RequestBody Map map) {
		try {
			semeval2010Service.insertOne(map);
			return semeval2010Service.getOneDoc(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}