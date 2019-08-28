package com.paloit.demo.SimpleApp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class reprensting an employee. Employee can have one manager.
 * 
 * @author Camille
 *
 */

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "email")
  private String email;

  @Column(name = "fullname")
  private String fullname;

  @Column(name = "arrival_date")
  @Temporal(TemporalType.DATE)
  private Date arrivalDate;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "manager_id")
  private Employee manager;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "manager", orphanRemoval = false)
  private List<Employee> managedEmployees;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public Date getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(Date arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public Employee getManager() {
    return manager;
  }

  public void setManager(Employee manager) {
    this.manager = manager;
  }

  public List<Employee> getManagedEmployees() {
    return managedEmployees;
  }

  public void setManagedEmployees(List<Employee> managedEmployees) {
    this.managedEmployees = managedEmployees;
  }

  public void addManagedEmployee(Employee employee) {
    if (managedEmployees == null) {
      managedEmployees = new ArrayList<>();
      managedEmployees.add(employee);
    } else if (!managedEmployees.contains(employee)) {
      managedEmployees.add(employee);
    }
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
    result = prime * result + id;
    result = prime * result + ((managedEmployees == null) ? 0 : managedEmployees.hashCode());
    result = prime * result + ((manager == null) ? 0 : manager.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Employee))
      return false;
    Employee other = (Employee) obj;
    if (arrivalDate == null) {
      if (other.arrivalDate != null)
        return false;
    } else if (!arrivalDate.equals(other.arrivalDate))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (fullname == null) {
      if (other.fullname != null)
        return false;
    } else if (!fullname.equals(other.fullname))
      return false;
    if (id != other.id)
      return false;
    if (managedEmployees == null) {
      if (other.managedEmployees != null)
        return false;
    }
    if (manager == null) {
      if (other.manager != null)
        return false;
    } else if (!manager.equals(other.manager))
      return false;
    return true;
  }


}
