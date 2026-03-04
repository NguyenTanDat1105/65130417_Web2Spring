package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	// Xây dựng action
    // mapping URL
    @GetMapping("/")
    public String trangChu() {
        return "index"; 
    }
    @GetMapping("/about")
    public String GioiThieu() {
    	return "about";
    }
}
