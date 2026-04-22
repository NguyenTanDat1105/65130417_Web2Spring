package thigk2.nguyentandat.Practise_QuanLySanPham.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thigk2.nguyentandat.Practise_QuanLySanPham.models.SanPham;
import thigk2.nguyentandat.Practise_QuanLySanPham.repositories.SanPhamRepository;

@Service
public class SanPhamService {
	@Autowired
	SanPhamRepository sanPhamRepository;
	
	public List<SanPham> getAllSanPham() {
		return sanPhamRepository.findAll();
	}
	
	public SanPham getSanPham (int id) {
		return sanPhamRepository.getReferenceById(id);
	}
	
	public void saveSanPham(SanPham sanpham) {
		sanPhamRepository.save(sanpham);
	}
	
	public void deleteSanPham (int id) {
		for (SanPham sp : sanPhamRepository.findAll()) {
			if (sp.getId() == id) sanPhamRepository.delete(sp);
		}
	}
}
