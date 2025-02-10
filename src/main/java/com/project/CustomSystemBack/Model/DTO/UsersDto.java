package com.project.CustomSystemBack.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private Boolean isActive;
    private Integer roleId;

}
