package ntu.datnguyen.QuanLyBanDienThoai.Services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ntu.datnguyen.QuanLyBanDienThoai.Repositories.RoleRepository;
import ntu.datnguyen.QuanLyBanDienThoai.Repositories.UserRepository;
import ntu.datnguyen.QuanLyBanDienThoai.models.Role;
import ntu.datnguyen.QuanLyBanDienThoai.models.User;
import ntu.datnguyen.QuanLyBanDienThoai.models.UserRegistrationDTO;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewUser(UserRegistrationDTO registrationDto) {
        if (userRepository.findByUsername(registrationDto.getUsername()).isPresent()) {
            throw new RuntimeException("Username đã tồn tại!");
        }
        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            throw new RuntimeException("Mật khẩu xác nhận không khớp!");
        }

        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setEnabled(true);

        // Gán role mặc định là ROLE_USER
        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName("ROLE_USER");
                    return roleRepository.save(newRole);
                });
        user.setRoles(Collections.singleton(userRole));

        userRepository.save(user);
    }
}
