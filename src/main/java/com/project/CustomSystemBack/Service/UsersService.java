package com.project.CustomSystemBack.Service;

import com.project.CustomSystemBack.Model.DTO.RolesDto;
import com.project.CustomSystemBack.Model.DTO.UsersDto;
import com.project.CustomSystemBack.Repository.RolesRepository;
import com.project.CustomSystemBack.Repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public void userInsert(String username, String password, Integer roleId) {
        usersRepository.userInsert(username, password, roleId);
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
