package com.emp.hsenid.hr_emp_manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.hsenid.hr_emp_manage.entities.Department;
import com.emp.hsenid.hr_emp_manage.repositories.DepartmentRepository;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  public List<Department> getAllDepartments() {
    return (List<Department>) departmentRepository.findAll();
  }

  public Optional<Department> getDepartmentById(Long id) {
    return departmentRepository.findById(id);
  }

  public Department addDepartment(Department department) {
    return departmentRepository.save(department);
  }

  public void deleteDepartment(Long id) {
    departmentRepository.deleteById(id);
  }
}
