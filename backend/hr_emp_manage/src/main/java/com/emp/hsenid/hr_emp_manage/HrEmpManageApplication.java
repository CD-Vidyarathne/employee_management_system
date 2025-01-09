package com.emp.hsenid.hr_emp_manage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HrEmpManageApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(HrEmpManageApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
    System.out.println("Employees : " + employeeService.fetchEmployees());
    ((ConfigurableApplicationContext) context).close();
  }

}
