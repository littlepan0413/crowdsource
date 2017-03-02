package com.kse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SemEval2010 {

	@RequestMapping("/")
	public String instance() {
		return "semeval2010";
	}
}