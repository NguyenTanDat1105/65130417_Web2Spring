package thigk2.nguyentandat.qlsanpham.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import thigk2.nguyentandat.qlsanpham.models.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
	NguoiDung findByUsername(String username);
}	