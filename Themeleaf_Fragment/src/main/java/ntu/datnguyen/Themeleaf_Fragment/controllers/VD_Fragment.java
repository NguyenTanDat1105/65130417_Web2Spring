package ntu.datnguyen.Themeleaf_Fragment.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VD_Fragment {
	@GetMapping("/")
	public String getFragment () {
		return "fragments";
	}
}
