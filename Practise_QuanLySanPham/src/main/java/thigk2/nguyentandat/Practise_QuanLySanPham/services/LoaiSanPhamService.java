package thigk2.nguyentandat.Practise_QuanLySanPham.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thigk2.nguyentandat.Practise_QuanLySanPham.models.LoaiSanPham;
import thigk2.nguyentandat.Practise_QuanLySanPham.repositories.LoaiSanPhamRepository;

@Service
public class LoaiSanPhamService {
	@Autowired
	LoaiSanPhamRepository loaiSanPhamRepository;
	
	public List<LoaiSanPham> getAllLoaiSanPham() {
		return loaiSanPhamRepository.findAll();
	}
	
	public LoaiSanPham getSanPham (int id) {
		return loaiSanPhamRepository.getReferenceById(id);
	}
	
	public void saveLoaiSanPham(LoaiSanPham sanpham) {
		loaiSanPhamRepository.save(sanpham);
	}
	
	public void deleteLoaiSanPham (int id) {
		for (LoaiSanPham sp : loaiSanPhamRepository.findAll()) {
			if (sp.getId() == id) loaiSanPhamRepository.delete(sp);
		}
	}
}
