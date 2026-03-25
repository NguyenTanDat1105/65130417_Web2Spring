package thiGK.ntu65130417.nguyentandat_fitCMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thiGK.ntu65130417.nguyentandat_fitCMS.models.Page;
import thiGK.ntu65130417.nguyentandat_fitCMS.repositories.PageRepository;

@Service
public class PageService {
	@Autowired
	PageRepository pRepos;
	// Dịch vụ lấy về tất cả các trang
	public List<Page> getAllPages () {
		return pRepos.findAll();
	}
	
	//Dịch vụ lấy thông tin 1 trang theo ID
	public Page getPageByID(int id) {
		return pRepos.getById(id);
		//return pRepos.findById(id).orElse(null);
	}
}
