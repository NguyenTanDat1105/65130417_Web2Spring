package thiGK.ntu65130417.nguyentandat_fitCMS.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import thiGK.ntu65130417.nguyentandat_fitCMS.models.Page;
import thiGK.ntu65130417.nguyentandat_fitCMS.repositories.PageRepository;

@RestController
public class RESTApiPageController {
	@Autowired
	PageRepository pService;
	
	@GetMapping("/restAPI/page/all")
	public List<Page> getAllPage() {
		List<Page> dsTrang = new ArrayList<Page>();
		//Test
		// dsTrang.add(new Page(0), "tenTrang", "tuKhoa", "noiDung", 0));
		//dsTrang = (ArrayList<Page>) pRepos.findAll();
		dsTrang = pService.getAllPage();
		return dsTrang;
	}
	
	@GetMapping("/restAPI/page/{id}")
	public Page getPage(@PathVariable("id") int id) {
		return pService.getPageByID(id);
	}
}
