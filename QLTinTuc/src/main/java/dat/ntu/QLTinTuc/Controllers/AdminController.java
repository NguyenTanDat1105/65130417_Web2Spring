package dat.ntu.QLTinTuc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dat.ntu.QLTinTuc.Services.LoaiTinService;
import dat.ntu.QLTinTuc.Services.TinTucService;
import dat.ntu.QLTinTuc.models.TinTuc;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TinTucService tinTucService;

    @Autowired
    private LoaiTinService loaiTinService;

    // 1. Hiển thị danh sách tin tức
    @GetMapping("/tintuc")
    public String listTinTuc(ModelMap model) {
        model.addAttribute("listTin", tinTucService.getAll());
        return "admin/list-tintuc";
    }

    // 2. Mở form thêm mới
    @GetMapping("/tintuc/add")
    public String showAddForm(ModelMap model) {
        model.addAttribute("tintuc", new TinTuc());
        model.addAttribute("listLoaiTin", loaiTinService.getAll()); // Để chọn loại tin trong dropdown
        return "admin/form-tintuc";
    }

    // 3. Xử lý Lưu (dùng chung cho cả Thêm và Sửa)
    @PostMapping("/tintuc/save")
    public String saveTinTuc(@ModelAttribute("tintuc") TinTuc tinTuc) {
        tinTucService.save(tinTuc);
        return "redirect:/admin/tintuc";
    }

    // 4. Mở form sửa
    @GetMapping("/tintuc/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        TinTuc tinTuc = tinTucService.getById(id);
        model.addAttribute("tintuc", tinTuc);
        model.addAttribute("listLoaiTin", loaiTinService.getAll());
        return "admin/form-tintuc";
    }

    // 5. Xóa tin tức
    @GetMapping("/tintuc/delete/{id}")
    public String deleteTinTuc(@PathVariable("id") Integer id) {
        tinTucService.delete(id);
        return "redirect:/admin/tintuc";
    }
}