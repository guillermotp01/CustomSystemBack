package com.project.CustomSystemBack.Controller;

import com.project.CustomSystemBack.Model.DTO.UsersDto;
import com.project.CustomSystemBack.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    private UsersService usersService;

    @Validated
    @PostMapping("/insert")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertUser(@RequestBody UsersDto usersDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            usersService.userInsert(usersDto);
            result.put("success", true);
            result.put("message", "El usuario fue registrado correctamente");
            result.put("data", usersDto);
        } catch (Exception e) {
            result.put("success", false);
            result.put("message", "Error de conexión");
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update")
    public void userUpdate(@RequestParam Integer id, @RequestParam String username, @RequestParam String password, @RequestParam Integer roleId) {
        usersService.userUpdate(id, username, password, roleId);
    }

    @DeleteMapping("/delete")
    public void userDelete(@RequestParam Integer id) {
        usersService.userDelete(id);
    }

    @GetMapping("/listAll")
    public List<UsersDto> userList() {
        return usersService.userList();
    }
}
