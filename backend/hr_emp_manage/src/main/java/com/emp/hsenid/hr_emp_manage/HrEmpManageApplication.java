package com.emp.hsenid.hr_emp_manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrEmpManageApplication {

  public static void main(String[] args) {
    SpringApplication.run(HrEmpManageApplication.class, args);
  }

  // @Override
  // public void run(String... args) throws Exception {
  // ApplicationContext context = new
  // ClassPathXmlApplicationContext("applicationContext.xml");
  // EmployeeService employeeService = (EmployeeService)
  // context.getBean("employeeService");
  // System.out.println("Employees : " + employeeService.fetchEmployees());
  // ((ConfigurableApplicationContext) context).close();
  // }

}
