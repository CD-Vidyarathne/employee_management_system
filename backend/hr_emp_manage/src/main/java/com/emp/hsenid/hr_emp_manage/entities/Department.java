package com.emp.hsenid.hr_emp_manage.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Department
 */
@Entity
@Table(name = "departments")
public class Department {

  @Id
  @Column(name = "department_id")
  private Long departmentId;

  @Enumerated(EnumType.STRING)
  @Column(name = "deparatment_name")
  private DepartmentName departmentName;

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public DepartmentName getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(DepartmentName departmentName) {
    this.departmentName = departmentName;
  }
}
