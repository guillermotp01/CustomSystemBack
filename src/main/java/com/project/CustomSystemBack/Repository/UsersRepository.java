package com.project.CustomSystemBack.Repository;

import com.project.CustomSystemBack.Model.DAO.UsersDao;
import com.project.CustomSystemBack.Model.DTO.UsersDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends JpaRepository<UsersDao, Long> {

    @Procedure(procedureName = "userInsert")
    void insertUser(
            @Param("p_username") String username,
            @Param("p_password") String password,
            @Param("p_email") String email,
            @Param("p_role_id") Integer roleId
    );

    @Procedure(name = "userUpdate")
    void userUpdate(Integer id, String username, String password, Integer roleId);

    @Procedure(name = "userDelete")
    void userDelete(Integer id);

    @Procedure(name = "userList")
    List<UsersDto> userList();

    UsersDao findByUsername(String username);
}
