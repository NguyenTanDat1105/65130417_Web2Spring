package com.example.B4_BMICalculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class B4_Controllers {
	@GetMapping("/") 
	public String B4() {
        return "form";
    }
	@PostMapping("/")
	public String BT_BMI (ModelMap m, HttpServletRequest h) {
		// từ khoá lấy từ form
		String chieucao = h.getParameter("height");
		String cannang = h.getParameter("weight");
		float Ccao = Float.parseFloat(chieucao);
		float Cnang = Float.parseFloat(cannang);
		float BMI = Cnang / ( Ccao * Ccao );
		// từ khoá để hiện View
		m.addAttribute("chieucao", chieucao);
		m.addAttribute("cannang", cannang);
		m.addAttribute("BMI", String.format("%.2f", BMI));
		return "index";
	}
}
