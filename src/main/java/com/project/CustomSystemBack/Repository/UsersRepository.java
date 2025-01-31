package com.project.CustomSystemBack.Repository;

import com.project.CustomSystemBack.Model.DAO.UsersDao;
import com.project.CustomSystemBack.Model.DTO.UsersDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface UsersRepository extends JpaRepository<UsersDao, Long> {

    @Procedure(name = "userInsert")
    void userInsert(String username, String password, Integer roleId);

    @Procedure(name = "userUpdate")
    void userUpdate(Integer id, String username, String password, Integer roleId);

    @Procedure(name = "userDelete")
    void userDelete(Integer id);

    @Procedure(name = "userList")
    List<UsersDto> userList();
}
