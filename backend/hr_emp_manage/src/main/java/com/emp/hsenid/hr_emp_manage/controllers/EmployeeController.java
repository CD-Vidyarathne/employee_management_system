package com.emp.hsenid.hr_emp_manage.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.hsenid.hr_emp_manage.entities.Department;
import com.emp.hsenid.hr_emp_manage.entities.DepartmentName;
import com.emp.hsenid.hr_emp_manage.entities.Employee;
import com.emp.hsenid.hr_emp_manage.entities.EmployeeId;
import com.emp.hsenid.hr_emp_manage.services.DepartmentService;
import com.emp.hsenid.hr_emp_manage.services.EmployeeService;

/*
 * EmployeeController
 */

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private DepartmentService departmentService;

  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/{depId}/{empId}")
  public ResponseEntity<Employee> getEmployeeByid(@PathVariable long depId, @PathVariable long empId) {
    EmployeeId id = new EmployeeId(empId, depId);
    Optional<Employee> e = employeeService.getEmployeeById(id);
    return e.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

    Optional<Department> dep = departmentService.getDepartmentById(employee.getId().getDepartmentId());

    if (dep.isPresent()) {
      employee.setDepartment(dep.get());
    } else {
      return ResponseEntity.badRequest().body(null);
    }

    employee.setJoiningDate(LocalDate.now());

    Employee savedEmployee = employeeService.addEmployee(employee);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
  }

  @RequestMapping(value = "/{depId}/{empId}", method = RequestMethod.PUT)
  public ResponseEntity<Employee> editEmployee(@PathVariable long depId, @PathVariable long empId,
      @RequestBody Employee employee) {
    EmployeeId id = new EmployeeId(empId, depId);
    Optional<Employee> existingEmployeeOpt = employeeService.getEmployeeById(id);

    if (existingEmployeeOpt.isPresent()) {
      Employee existingEmployee = existingEmployeeOpt.get();

      existingEmployee.setName(employee.getName());
      existingEmployee.setNic(employee.getNic());

      // NOTE:Because department is part of the composite key, you can't change the
      // department after the assignment.
      if (employee.getDepartment() != null
          && !employee.getDepartment().getDepartmentId().equals(existingEmployee.getDepartment().getDepartmentId())) {
        Department newDepartment = departmentService.getDepartmentById(employee.getDepartment().getDepartmentId())
            .orElseThrow(() -> new RuntimeException("Department not found"));
        EmployeeId newId = new EmployeeId(existingEmployee.getId().getEmployeeId(), newDepartment.getDepartmentId());
        existingEmployee.setId(newId);
        existingEmployee.setDepartment(newDepartment);
      }

      Employee updatedEmployee = employeeService.editEmployee(existingEmployee);
      return ResponseEntity.ok(updatedEmployee);
    }

    return ResponseEntity.notFound().build();
  }

  @RequestMapping(value = "/{depId}/{empId}", method = RequestMethod.DELETE)
  public ResponseEntity<Void> deleteEmployee(@PathVariable long depId, @PathVariable long empId) {
    EmployeeId id = new EmployeeId(empId, depId);
    Optional<Employee> existingEmployee = employeeService.getEmployeeById(id);
    if (existingEmployee.isPresent()) {
      employeeService.deleteEmployee(id);
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping("/searchByName")
  public List<Employee> searchEmployeeByName(@RequestParam String name) {
    return employeeService.viewEmployeeByName(name);
  }

  @GetMapping("/searchByDepartment")
  public List<Employee> searchEmployeeByDepartment(@RequestParam DepartmentName departmentName) {
    return employeeService.getEmployeesByDepartmentName(departmentName);
  }
}
