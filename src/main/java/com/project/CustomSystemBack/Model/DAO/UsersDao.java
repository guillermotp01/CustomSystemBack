package com.project.CustomSystemBack.Model.DAO;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "T_USERS")
public class UsersDao {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "enabled")
    private Boolean enabled;
}
