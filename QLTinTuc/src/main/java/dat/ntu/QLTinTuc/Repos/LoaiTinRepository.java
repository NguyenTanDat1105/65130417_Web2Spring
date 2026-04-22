package dat.ntu.QLTinTuc.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import dat.ntu.QLTinTuc.models.LoaiTinTuc;

public interface LoaiTinRepository extends JpaRepository<LoaiTinTuc, Integer> {
    
}
