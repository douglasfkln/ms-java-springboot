package com.uri.progweb.userdep.repositories;

import com.uri.progweb.userdep.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
