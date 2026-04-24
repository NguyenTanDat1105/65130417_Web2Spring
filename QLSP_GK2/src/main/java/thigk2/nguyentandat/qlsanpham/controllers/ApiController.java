package thigk2.nguyentandat.qlsanpham.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thigk2.nguyentandat.qlsanpham.models.LoaiSP;
import thigk2.nguyentandat.qlsanpham.models.SP;
import thigk2.nguyentandat.qlsanpham.repos.LoaiSPRepository;
import thigk2.nguyentandat.qlsanpham.repos.SPRepository;

@RestController
@RequestMapping("/api") 
public class ApiController {

    @Autowired
    private LoaiSPRepository loaiSPRepo;

    @Autowired
    private SPRepository spRepo;

    @GetMapping("/loai-sp")
    public List<LoaiSP> getDanhSachLoaiSP() {
        return loaiSPRepo.findAll();
    }

    @GetMapping("/san-pham/loai/{id}")
    public List<SP> getSanPhamTheoLoai(@PathVariable("id") Integer id) {
        return spRepo.findByLoaiSP_Id(id);
    }
}