package com.example.databasestudy.repository;

import com.example.databasestudy.domain.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {

}
