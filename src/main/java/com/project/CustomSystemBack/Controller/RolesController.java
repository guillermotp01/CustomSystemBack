package com.project.CustomSystemBack.Controller;

import com.project.CustomSystemBack.Model.DTO.RolesDto;
import com.project.CustomSystemBack.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @PostMapping("/insert")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertRole(@Validated @RequestBody RolesDto rolesDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            rolesService.insertRole(rolesDto);
            System.out.println("DATOS RECIBIDOS:" + rolesDto);
            result.put("success", true);
            result.put("message", "El rol fue registrado correctamente");
            result.put("data", rolesDto);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "Error de conexión");
        }
        return ResponseEntity.ok(result);
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
