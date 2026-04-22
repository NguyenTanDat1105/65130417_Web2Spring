package dat.ntu.QLTinTuc.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dat.ntu.QLTinTuc.Services.TinTucService;
import dat.ntu.QLTinTuc.models.TinTuc;

@Controller
public class HomeController {

    @Autowired
    private TinTucService tinTucService;

    @GetMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("listTin", tinTucService.getAll());
        return "user/home";
    }

    @GetMapping("/tin-tuc/{id}")
    public String viewDetail(@PathVariable("id") Integer id, ModelMap model) {
        TinTuc tin = tinTucService.getById(id);
        if (tin != null) {
            model.addAttribute("tin", tin);
            return "user/detail";
        }
        return "redirect:/";
    }
}