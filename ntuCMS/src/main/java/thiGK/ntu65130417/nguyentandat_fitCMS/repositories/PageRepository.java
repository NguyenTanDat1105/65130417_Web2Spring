package thiGK.ntu65130417.nguyentandat_fitCMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import thiGK.ntu65130417.nguyentandat_fitCMS.models.Page;

@RestController
public interface PageRepository extends JpaRepository<Page, Integer>{
	
}
