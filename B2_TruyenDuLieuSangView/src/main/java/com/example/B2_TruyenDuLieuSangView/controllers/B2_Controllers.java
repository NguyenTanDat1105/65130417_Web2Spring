package com.example.B2_TruyenDuLieuSangView.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class B2_Controllers {
	//SV tạo dự án như trên, truyền dữ liệu: MSSV, Họ tên SV, Năm sinh, Giới tính  từ Controller --> View. Và hiển thị tại View
	@GetMapping("/")
	public String sinhVien (ModelMap m) {
		String mssv = "65130417";
		String HovaTen = "Nguyen Tan Dat";
		String namsinh = "2005";
		String gioitinh = "Nam";
		m.addAttribute("Mssv", mssv);
		m.addAttribute("hoten", HovaTen);
		m.addAttribute("Namsinh", namsinh);
		m.addAttribute("Gtinh", gioitinh);
		return "index";
	}
	
}
