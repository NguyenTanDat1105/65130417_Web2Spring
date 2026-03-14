package thiGK.ntu65130417.nguyentandat_fitCMS.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import thiGK.ntu65130417.nguyentandat_fitCMS.models.Page;
import thiGK.ntu65130417.nguyentandat_fitCMS.models.Post;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class APIPageController {
	ArrayList<Page> dsTrang = new ArrayList<Page> ();
	public APIPageController () {
		dsTrang.add(new Page ("1","Giới thiệu", "intro", "Chào mừng đến với NTU", "0"));
		dsTrang.add(new Page ("2", "Đào tạo", "train", "Thông tin đào tạo", "0"));
		dsTrang.add(new Page ("3", "Khoa CNTT", "it", "Nội dung khoa CNTT", "2"));
	}
	@GetMapping("/api/Pages")
	public ArrayList<Page> getAllPages() {
		return dsTrang;
	}

	@GetMapping("/api/oneObj")
	public Page getOneObj() {
		return new Page ("001", "GioiThieu", "từ khoá", "nội dung", "5");
	}
	
	@GetMapping("/api/Pages/{id}")
	public Page getPageId (@PathVariable String id) {
		for (Page p: dsTrang)
			if ( p.getId()==id)
				return p;
		return null;
	}
	
	@PostMapping("/api/Pages/add")
	public boolean pageAdd(@RequestBody Page entity) {
		boolean kq = dsTrang.add(entity);
		return kq;
	}
	
	@PutMapping("api/Pages/update/{id}")
	public boolean pageUpdate(@PathVariable("id") String id, @RequestBody Page entity) {
		// Tìm page
		for (Page p:dsTrang)
			if (p.getId().equals(id))
			{
				dsTrang.remove(p);
				dsTrang.add(entity);
				return true;
			}
		return false;
	}
	@DeleteMapping("/api/Pages/delete/{id}")
	public boolean pageDelete(@PathVariable("id") String id) {
		// Tìm page
		for (Page p:dsTrang)
			if (p.getId().equals(id))
			{
				Boolean kq =  dsTrang.remove(p);
				return kq;
			}
		return false;
	}
	
}
