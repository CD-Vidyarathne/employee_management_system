package com.emp.hsenid.hr_emp_manage.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

/**
 * Employee
 */
@Entity
@Table(name = "employees")
public class Employee {
  @EmbeddedId
  private EmployeeId id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "nic", nullable = false)
  private String nic;

  @Column(name = "joining_date", nullable = false)
  private LocalDate joiningDate;

  @ManyToOne
  @MapsId("departmentId")
  @JoinColumn(name = "department_id", nullable = false)
  private Department department;

  public EmployeeId getId() {
    return id;
  }

  public void setId(EmployeeId id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNic() {
    return nic;
  }

  public void setNic(String nic) {
    this.nic = nic;
  }

  public LocalDate getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(LocalDate joiningDate) {
    this.joiningDate = joiningDate;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }
}
