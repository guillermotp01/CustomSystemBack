package com.project.CustomSystemBack.Service;

import com.project.CustomSystemBack.Model.DTO.UsersDto;
import com.project.CustomSystemBack.Repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    public void userInsert(UsersDto usersDto) {
        String encodedPassword = passwordEncoder.encode(usersDto.getPassword());

        if (usersDto.getRoleId() == null) {
            usersDto.setRoleId(1);
        }

        usersRepository.insertUser(
                usersDto.getUsername(),
                encodedPassword,
                usersDto.getEmail(),
                usersDto.getRoleId()
        );
    }

    public void userUpdate(Integer id, String username, String password, Integer roleId) {
        usersRepository.userUpdate(id, username, password, roleId);
    }

    public void userDelete(Integer id) {
        usersRepository.userDelete(id);
    }

    @Transactional
    public List<UsersDto> userList() {
        return usersRepository.userList();
    }
}
