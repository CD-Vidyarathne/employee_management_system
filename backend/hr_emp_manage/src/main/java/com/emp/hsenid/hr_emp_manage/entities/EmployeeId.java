package com.emp.hsenid.hr_emp_manage.entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

/**
 * EmployeeId
 */
@Embeddable
public class EmployeeId implements Serializable {
  private Long employeeId;
  private Long departmentId;

  public EmployeeId() {
  }

  public EmployeeId(Long employeeId, Long departmentId) {
    this.employeeId = employeeId;
    this.departmentId = departmentId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    EmployeeId that = (EmployeeId) o;
    return Objects.equals(this.employeeId, that.employeeId) && Objects.equals(this.departmentId, that.departmentId);
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(employeeId, departmentId);
  }

}
