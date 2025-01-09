package com.emp.hsenid.hr_emp_manage.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

/**
 * EmployeeId
 */
@Embeddable
public class EmployeeId implements Serializable {
  private Long employeeId;
  private Long departmentId;

  public Long getEmployeeId() {
    return employeeId;

  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

}
