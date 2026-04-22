package thigk2.nguyentandat.Practise_QuanLySanPham.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import thigk2.nguyentandat.Practise_QuanLySanPham.models.LoaiSanPham;
import thigk2.nguyentandat.Practise_QuanLySanPham.models.SanPham;
import thigk2.nguyentandat.Practise_QuanLySanPham.services.LoaiSanPhamService;
import thigk2.nguyentandat.Practise_QuanLySanPham.services.SanPhamService;

@RestController
public class RController {
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	
	@GetMapping("/testAPISanPham")
	public List<SanPham> getAllSanPham ()
	{
		return sanPhamService.getAllSanPham();
	}
	
	@GetMapping("/testAPILoaiSanPham")
	public List<LoaiSanPham> getAllLoaiSanPham ()
	{
		return loaiSanPhamService.getAllLoaiSanPham();
	}
}
