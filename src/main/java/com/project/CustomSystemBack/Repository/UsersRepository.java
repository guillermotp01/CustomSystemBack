package com.project.CustomSystemBack.Repository;

import com.project.CustomSystemBack.Model.DAO.UsersDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersDao, Long> {

}
