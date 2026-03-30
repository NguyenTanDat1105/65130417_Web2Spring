package ntu.datnguyen.QuanLyBanDienThoai.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ntu.datnguyen.QuanLyBanDienThoai.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}