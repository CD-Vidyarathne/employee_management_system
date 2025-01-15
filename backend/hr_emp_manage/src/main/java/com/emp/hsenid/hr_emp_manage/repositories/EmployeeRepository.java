package com.emp.hsenid.hr_emp_manage.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emp.hsenid.hr_emp_manage.entities.DepartmentName;
import com.emp.hsenid.hr_emp_manage.entities.Employee;
import com.emp.hsenid.hr_emp_manage.entities.EmployeeId;

/**
 * EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, EmployeeId> {

  List<Employee> findByName(String name);

  List<Employee> findByDepartment_DepartmentName(DepartmentName DepartmentName);

  List<Employee> findByNicStartingWith(String nicPrefix);

  @Query("SELECT e FROM Employee e WHERE e.joiningDate <= :yearBeforeFive")
  List<Employee> findEmployeesWithMoreThanFiveYears(LocalDate yearBeforeFive);

}
