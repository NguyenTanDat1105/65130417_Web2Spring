package dat.ntu.QLTinTuc.RestControllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dat.ntu.QLTinTuc.Services.TinTucService;
import dat.ntu.QLTinTuc.models.TinTuc;

@RestController
public class TinTucRestController {
    @Autowired
    TinTucService tinTucService;

    @GetMapping("/testAPI")
    public List<TinTuc> getlistAllTinTuc() {
        return tinTucService.getAll();
    }
}