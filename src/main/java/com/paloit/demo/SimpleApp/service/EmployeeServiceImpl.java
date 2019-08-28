package com.paloit.demo.SimpleApp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.paloit.demo.SimpleApp.model.Employee;
import com.paloit.demo.SimpleApp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository repository;

  public EmployeeServiceImpl(EmployeeRepository repository) {
    this.repository = repository;
  }

  @Override
  public Employee findEmployeeById(int id) {
    Employee employee = repository.findById(id).orElse(null);
    return employee;
  }

  @Override
  public List<Employee> findEmployeesByManagerId(int id) {
    Optional<Employee> manager = repository.findById(id);
    if (manager.isPresent()) {
      return manager.get().getManagedEmployees();
    }
    return new ArrayList<>();
  }

  @Override
  public void deleteEmployee(Employee employee) {

    for (Employee managedEmployee : employee.getManagedEmployees()) {
      managedEmployee.setManager(null);
      saveEmployee(managedEmployee);
    }

    repository.delete(employee);
  }

  @Override
  public void saveEmployee(Employee employee) {
    repository.save(employee);
  }

  @Override
  public void updateEmployee(Employee employee) {
    repository.save(employee);

  }

  @Override
  public List<Employee> getAllEmployess() {
    return repository.findAll();
  }

  @Override
  public List<Employee> findEmployeeByFullName(String fullName) {
    return repository.findByFullname(fullName);
  }

  @Override
  public void saveEmployeeWithManager(Employee employee, String managerId) {
    Employee manager = findEmployeeById(Integer.parseInt(managerId));
    if (manager != null) {
      employee.setManager(manager);
    }
    saveEmployee(employee);
  }

  @Override
  public List<Employee> getEmployeesBeforeDate(Date date) {
    return repository.findByArrivalDateBefore(date);
  }

  @Override
  public List<Employee> getEmployeesAfterDate(Date date) {
    return repository.findByArrivalDateAfter(date);
  }

}
