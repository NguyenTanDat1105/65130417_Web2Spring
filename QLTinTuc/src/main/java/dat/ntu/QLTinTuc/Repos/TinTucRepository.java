package dat.ntu.QLTinTuc.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import dat.ntu.QLTinTuc.models.TinTuc;

public interface TinTucRepository extends JpaRepository<TinTuc, Integer> {
    
}