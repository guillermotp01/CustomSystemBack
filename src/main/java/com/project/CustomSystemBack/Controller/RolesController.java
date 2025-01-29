package com.project.CustomSystemBack.Controller;

import com.project.CustomSystemBack.Model.DTO.RolesDto;
import com.project.CustomSystemBack.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @PostMapping("/create")
    public void roleInsert(@RequestParam String name, @RequestParam String description) {
        rolesService.roleInsert(name, description);
    }

    @PutMapping("/update")
    public void roleUpdate(@RequestParam Integer id, @RequestParam String name, @RequestParam String description) {
        rolesService.roleUpdate(id, name, description);
    }

    @DeleteMapping("/delete")
    public void roleDelete(@RequestParam Integer id) {
        rolesService.roleDelete(id);
    }

    @GetMapping("/listAll")
    public List<RolesDto> roleList() {
        return rolesService.roleList();
    }
}
