package com.paloit.demo.SimpleApp.service;

import java.util.Date;
import java.util.List;
import com.paloit.demo.SimpleApp.model.Employee;

/**
 * Management layer for the employees
 * 
 * @author Camille
 *
 */
public interface EmployeeService {

  /**
   * Return an employee
   * 
   * @param id
   * @return the employee
   */
  public Employee findEmployeeById(int id);

  /**
   * find an employee by his fullname
   * 
   * @param fullName
   * @return
   */
  public List<Employee> findEmployeeByFullName(String fullName);

  /**
   * return all the employees in the repository
   * 
   * @return java.util.List of all employees
   */
  public List<Employee> getAllEmployess();

  /**
   * Return all employee managed by a manager
   * 
   * @param id
   * @return java.util.List containing all managed employee
   */
  public List<Employee> findEmployeesByManagerId(int id);

  /**
   * Delete from repository the employee
   * 
   * @param employee
   */
  public void deleteEmployee(Employee employee);

  /**
   * Save into repository the employee
   * 
   * @param employee
   */
  public void saveEmployee(Employee employee);

  /**
   * Create an employee, and if manager is specified try to bind it
   * 
   * @param employee
   * @param managerId
   */
  public void saveEmployeeWithManager(Employee employee, String managerId);

  /**
   * Update in repository the employee
   * 
   * @param employee
   */
  public void updateEmployee(Employee employee);

  /**
   * Look for all the employees who joined before certained date
   * 
   * @param date
   * @return
   */
  public List<Employee> getEmployeesBeforeDate(Date date);

  /**
   * Look for all the employees who joined after certain date
   * 
   * @param date
   * @return
   */
  public List<Employee> getEmployeesAfterDate(Date date);

}
