package com.example.databasestudy.repository;

import com.example.databasestudy.domain.work.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work,Long> {
}
