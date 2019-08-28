package com.paloit.demo.SimpleApp;

import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.paloit.demo.SimpleApp.model.Employee;
import com.paloit.demo.SimpleApp.service.EmployeeService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleAppApplicationTests {

	@Autowired
	EmployeeService employeeService;
	
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	@Test
	public void getEmployee() {
		Employee employee = employeeService.findEmployeeById(1);
		Assert.assertNotNull(employee);
	}
	
	@Test
	public void deleteEmployee() {
		Employee employee = employeeService.findEmployeeById(1);
		employeeService.deleteEmployee(employee);
		employee = employeeService.findEmployeeById(1);
		Assert.assertNull(employee);
	}
	
	@Test
	public void createEmployee() {
		Employee employee = new Employee();
		employee.setArrivalDate(new Date());
		employee.setFullname("toto toto");
		employeeService.saveEmployee(employee);
		List<Employee> employeeList = employeeService.findEmployeeByFullName(employee.getFullname());
		if(employeeList.isEmpty())
		{
			fail();
		}
	}
	
	@Test
	public void updateEmployee() throws Exception {
		Employee employee = employeeService.findEmployeeById(2);
		
		employee.setFullname("titi titi");
		Date now = formatter.parse(formatter.format(new Date()));
		employee.setArrivalDate(now);
		
		employeeService.saveEmployee(employee);
		
		employee = employeeService.findEmployeeByFullName("titi titi").get(0);
		
		Assert.assertEquals("titi titi", employee.getFullname());
		Assert.assertEquals(now, employee.getArrivalDate());
	}
	
	@Test
	public void assertEquals()
	{
		Employee employee1 = employeeService.findEmployeeById(3);
		Employee employee2 = employeeService.findEmployeeById(3);
		Assert.assertEquals(employee1,employee2);
	}
	
}
