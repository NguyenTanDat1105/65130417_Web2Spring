package thiGK.ntu65130417.nguyentandat_fitCMS.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import thiGK.ntu65130417.nguyentandat_fitCMS.models.Page;
import thiGK.ntu65130417.nguyentandat_fitCMS.models.Post;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home () {
		return "dashboard";
	}
	//Tạo danh sách Page, Post
	ArrayList<Page> dsTrang = new ArrayList<Page> ();
	ArrayList<Post> dsBaiViet = new ArrayList<Post> ();
	
	//Hàm khởi tạo để tạo mới cho
	public HomeController () {
		dsTrang.add(new Page ("1","Giới thiệu", "intro", "Chào mừng đến với NTU", "0"));
		dsTrang.add(new Page ("2", "Đào tạo", "train", "Thông tin đào tạo", "0"));
		dsTrang.add(new Page ("3", "Khoa CNTT", "it", "Nội dung khoa CNTT", "2"));
		dsBaiViet.add(new Post("1", "Thông báo học vụ", "Nội dung thông báo...", "Tin tức"));
	    dsBaiViet.add(new Post("2", "Kế hoạch thi GK", "Lịch thi chi tiết...", "Thông báo"));
	    dsBaiViet.add(new Post("3", "Seminar CNTT", "Giới thiệu công nghệ mới...", "Sự kiện"));
	}
	
	//PAGE
	
	@GetMapping("/page/all")
	public String getTatCaTrang (ModelMap m) {
		
		m.addAttribute("listPage", dsTrang);
		return "allpage"; //allpage.html
	}
	
	@GetMapping("/page/new")
	public String createPage (ModelMap m) {
		return "addpage"; //addpage.html
	}
	@PostMapping("/page/new")
	public String addPage(ModelMap m, HttpServletRequest h) {
		String id = h.getParameter("id");
		String pageName = h.getParameter("pName");
		String keyword = h.getParameter("kword");
		String content = h.getParameter("c");
		String parentPageId = h.getParameter("pPageId");
		dsTrang.add(new Page(id, pageName, keyword, content, parentPageId));
		m.addAttribute("listPage", dsTrang);
		return "allpage";
	}
	
	
	//POST
	
	@GetMapping("/post/all")
	public String getTatCaBaiViet (ModelMap m) {
		m.addAttribute("listPost", dsBaiViet);
		return "allpost";
	}
	
	@GetMapping("/post/new")
	public String createPost (ModelMap m) {
		return "addpost";
	}
	
	@PostMapping("/post/new")
	public String addPost(ModelMap m, HttpServletRequest h) {
		String id = h.getParameter("id");
		String title = h.getParameter("title");
		String content = h.getParameter("content");
		String categoryID = h.getParameter("cID");
		dsBaiViet.add(new Post(id, title, content, categoryID));
		m.addAttribute("listPost", dsBaiViet);
		return "allpost";
	}
}
