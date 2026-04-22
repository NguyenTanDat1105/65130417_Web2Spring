package thigk2.nguyentandat.Practise_QuanLySanPham.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import thigk2.nguyentandat.Practise_QuanLySanPham.models.SanPham;
import thigk2.nguyentandat.Practise_QuanLySanPham.models.LoaiSanPham;
import thigk2.nguyentandat.Practise_QuanLySanPham.services.LoaiSanPhamService;
import thigk2.nguyentandat.Practise_QuanLySanPham.services.SanPhamService;

@Controller
public class AdminController {
	@Autowired
	SanPhamService sanPhamService;
	LoaiSanPhamService loaiSanPhamService;
	
	@GetMapping("/admin")
	public String getAll(ModelMap m) {
		m.addAttribute("dsSanPham", sanPhamService.getAllSanPham());
		m.addAttribute("dsLoaiSanPham", loaiSanPhamService.getAllLoaiSanPham());
		return "admin";
	}
	
	@PostMapping("/admin/save")
	public String save (@ModelAttribute("sanpham") SanPham sanPham) {
		sanPhamService.saveSanPham(sanPham);
		return "redirect:/admin";
	}
	
	@PostMapping("/admin/loai/save")
	public String save (@ModelAttribute("loaisanpham") LoaiSanPham loaiSanPham) {
		loaiSanPhamService.saveLoaiSanPham(loaiSanPham);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/delete/{id}")
	public String delete (@PathVariable("id") int id) {
		sanPhamService.deleteSanPham(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/loai/delete/{id}")
	public String deleteLoai (@PathVariable("id") int id) {
		loaiSanPhamService.deleteLoaiSanPham(id);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/edit/{id}")
	public String editSanPham (@PathVariable("id") int id, ModelMap m) {
		m.addAttribute("sanpham", sanPhamService.getSanPham(id));
		m.addAttribute("dsLoaiSP", loaiSanPhamService.getAllLoaiSanPham());
		return "updateSanPham";
	}
	
}
