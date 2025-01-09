package com.emp.hsenid.hr_emp_manage;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * EmployeeService
 */
@Service
public class EmployeeService {

  private List<String> employeeNames;
  private List<String> nicNumbers;
  private List<String> departments;

  public List<String> fetchEmployees() {
    return employeeNames;
  }

  public void setEmployeeNames(List<String> employeeNames) {
    this.employeeNames = employeeNames;
  }

  public List<String> fetchNicNumbers() {
    return nicNumbers;
  }

  public void setNicNumbers(List<String> nicNumbers) {
    this.nicNumbers = nicNumbers;
  }

  public List<String> fetchDepartments() {
    return departments;
  }

  public void setDepartments(List<String> departments) {
    this.departments = departments;
  }

  @PostConstruct
  public void afterInit() {
    System.out.println("*----------------------*");
    System.out.println("Post Construct: Employee Service is initialized");
    System.out.println("*----------------------*");
  }

  @PreDestroy
  public void beforeDestroy() {
    System.out.println("*----------------------*");
    System.out.println("Pre Destroy: Employee Service is cleaning up.");
    System.out.println("*----------------------*");
  }
}
