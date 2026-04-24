package thigk2.nguyentandat.qlsanpham.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import thigk2.nguyentandat.qlsanpham.models.SP;

public interface SPRepository extends JpaRepository<SP, Integer> {
    List<SP> findByLoaiSP_Id(Integer loaiId);
}