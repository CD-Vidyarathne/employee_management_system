package com.emp.hsenid.hr_emp_manage.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.hsenid.hr_emp_manage.entities.DepartmentName;
import com.emp.hsenid.hr_emp_manage.entities.Employee;
import com.emp.hsenid.hr_emp_manage.entities.EmployeeId;
import com.emp.hsenid.hr_emp_manage.repositories.EmployeeRepository;

/**
 * EmployeeService
 */
@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public Employee addEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  public List<Employee> getAllEmployees() {
    return (List<Employee>) employeeRepository.findAll();
  }

  public Optional<Employee> getEmployeeById(EmployeeId id) {
    return employeeRepository.findById(id);
  }

  public List<Employee> viewEmployeeByName(String name) {
    return employeeRepository.findByName(name);
  }

  public List<Employee> getEmployeesByDepartmentName(DepartmentName departmentName) {
    return employeeRepository.findByDepartment_DepartmentName(departmentName);
  }

  public Employee editEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  public void deleteEmployee(EmployeeId employeeId) {
    employeeRepository.deleteById(employeeId);
  }

  public List<Employee> getEmployeesWithNicStartingWithNinety() {
    return employeeRepository.findByNicStartingWith("90");
  }

  public List<Employee> getEmployeesWithMoreThanFiveYears() {
    return employeeRepository.findEmployeesWithMoreThanFiveYears(LocalDate.now().minus(Period.ofYears(5)));
  }

}
