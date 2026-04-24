package thigk2.nguyentandat.quanlysanpham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import thigk2.nguyentandat.quanlysanpham.models.NguoiDung;

public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    NguoiDung findByUsername(String username);
}