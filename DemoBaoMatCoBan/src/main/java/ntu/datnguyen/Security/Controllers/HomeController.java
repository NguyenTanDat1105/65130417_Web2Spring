package ntu.datnguyen.Security.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "homepage";
	}
	
	@GetMapping("/products/")
	public String indexp() {
		return "indexSanpham";
	}
	
	@GetMapping("/admincp/")
	public String indexAd() {
		return "indexAdmin";
	}
	
	@GetMapping("/hello")
	public String hl() {
		return "hello";
	}
}
