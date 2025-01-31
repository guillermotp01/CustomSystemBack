package com.project.CustomSystemBack.Controller;

import com.project.CustomSystemBack.Model.DTO.RolesDto;
import com.project.CustomSystemBack.Model.DTO.UsersDto;
import com.project.CustomSystemBack.Service.RolesService;
import com.project.CustomSystemBack.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {


    @Autowired
    private UsersService usersService;

    @PostMapping("/create")
    public void userInsert(@RequestParam String username, @RequestParam String password, @RequestParam Integer roleId) {
        usersService.userInsert(username, password, roleId);
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
