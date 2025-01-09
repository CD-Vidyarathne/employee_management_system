package com.emp.hsenid.hr_emp_manage.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Employee
 */
@Entity
@Table(name = "employees")
public class Employee {
  @EmbeddedId
  private int id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "nic", nullable = false)
  private String nic;

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
}
