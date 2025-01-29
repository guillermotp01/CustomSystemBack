package com.project.CustomSystemBack.Service;

import com.project.CustomSystemBack.Model.DTO.RolesDto;
import com.project.CustomSystemBack.Repository.RolesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public void roleInsert(String name, String description) {
        rolesRepository.roleInsert(name, description);
    }

    public void roleUpdate(Integer id, String name, String description) {
        rolesRepository.roleUpdate(id, name, description);
    }

    public void roleDelete(Integer id) {
        rolesRepository.roleDelete(id);
    }

    @Transactional
    public List<RolesDto> roleList() {
        return rolesRepository.roleList();
    }
}
