package com.uri.progweb.userdep.services;

import com.uri.progweb.userdep.entities.Department;
import com.uri.progweb.userdep.exceptions.DepartmentNotFoundException;
import com.uri.progweb.userdep.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public List<Department> findAll() {
        return repository.findAll();
    }

    public Department findById(Long id) {
        Optional<Department> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }

        throw new DepartmentNotFoundException();
    }

    public Department create(Department department) {
        return repository.save(department);
    }

    public void delete(Long id) {
        // Department department = findById(id);
        // repository.delete(department);
        repository.deleteById(id);
    }

    public Department update(Long id, Department newDepartment) {
        Department currentDepartment = findById(id);
        currentDepartment.setName(newDepartment.getName());
        Department department = repository.save(currentDepartment);
        return department;
    }
}
