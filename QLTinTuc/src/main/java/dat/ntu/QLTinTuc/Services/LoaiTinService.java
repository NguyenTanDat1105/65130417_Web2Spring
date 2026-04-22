package dat.ntu.QLTinTuc.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dat.ntu.QLTinTuc.Repos.LoaiTinRepository;
import dat.ntu.QLTinTuc.models.LoaiTinTuc;

@Service
public class LoaiTinService {
    @Autowired
    private LoaiTinRepository repo;

    public List<LoaiTinTuc> getAll() { return repo.findAll(); }
    public LoaiTinTuc getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(LoaiTinTuc loai) { repo.save(loai); }
    public void delete(Integer id) { repo.deleteById(id); }
}