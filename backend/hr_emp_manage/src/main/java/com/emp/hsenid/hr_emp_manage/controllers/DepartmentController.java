
package com.emp.hsenid.hr_emp_manage.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emp.hsenid.hr_emp_manage.entities.Department;
import com.emp.hsenid.hr_emp_manage.services.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @GetMapping
  public List<Department> getAllDepartments() {
    return departmentService.getAllDepartments();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
    Optional<Department> department = departmentService.getDepartmentById(id);
    return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public Department addDepartment(@RequestBody Department department) {
    return departmentService.addDepartment(department);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
    departmentService.deleteDepartment(id);
    return ResponseEntity.noContent().build();
  }
}
