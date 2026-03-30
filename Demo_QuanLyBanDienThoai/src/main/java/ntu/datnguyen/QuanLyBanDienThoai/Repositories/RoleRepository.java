package ntu.datnguyen.QuanLyBanDienThoai.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ntu.datnguyen.QuanLyBanDienThoai.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}