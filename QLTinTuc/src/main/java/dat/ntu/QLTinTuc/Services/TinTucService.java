package dat.ntu.QLTinTuc.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dat.ntu.QLTinTuc.Repos.TinTucRepository;
import dat.ntu.QLTinTuc.models.TinTuc;

@Service
public class TinTucService {
    @Autowired
    private TinTucRepository repo;

    public List<TinTuc> getAll() { return repo.findAll(); }
    public TinTuc getById(Integer id) { return repo.findById(id).orElse(null); }
    public void save(TinTuc tin) { repo.save(tin); }
    public void delete(Integer id) { repo.deleteById(id); }
}