package com.paloit.demo.SimpleApp.repository;

import org.springframework.stereotype.Repository;
import com.paloit.demo.SimpleApp.model.Employee;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

  List<Employee> findByManagerId(int id);

  @Override
  List<Employee> findAll();

  List<Employee> findByFullname(String fullName);

  List<Employee> findByArrivalDateAfter(Date date);

  List<Employee> findByArrivalDateBefore(Date date);

}
