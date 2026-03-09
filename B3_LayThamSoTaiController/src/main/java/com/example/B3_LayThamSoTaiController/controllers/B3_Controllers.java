package com.example.B3_LayThamSoTaiController.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class B3_Controllers {
	@GetMapping ("/") 
	public String B3 (ModelMap m, HttpServletRequest h) {
		String tk = h.getParameter("taikhoan");
		String mk = h.getParameter("matkhau");
		m.addAttribute("tk", tk);
		m.addAttribute("mk", mk);
		return "index";
	}
}
