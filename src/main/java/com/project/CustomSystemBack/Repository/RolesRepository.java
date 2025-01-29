package com.project.CustomSystemBack.Repository;

import com.project.CustomSystemBack.Model.DAO.RolesDao;
import com.project.CustomSystemBack.Model.DTO.RolesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface RolesRepository extends JpaRepository<RolesDao, Long> {

    @Procedure(name = "roleInsert")
    void roleInsert(String name, String description);

    @Procedure(name = "roleUpdate")
    void roleUpdate(Integer id, String name, String description);

    @Procedure(name = "roleDelete")
    void roleDelete(Integer id);

    @Procedure(name = "roleList")
    List<RolesDto> roleList();
}
