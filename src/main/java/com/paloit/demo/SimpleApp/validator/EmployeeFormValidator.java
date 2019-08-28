package com.paloit.demo.SimpleApp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.paloit.demo.SimpleApp.model.Employee;

@Component
public class EmployeeFormValidator implements Validator {

  private final EmailValidator emailValidator;

  public EmployeeFormValidator(EmailValidator emailValidator) {
    this.emailValidator = emailValidator;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return Employee.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullname", "NotEmpty.employeeForm.fullname");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.employeeForm.email");

    Employee employee = (Employee) target;

    if (!emailValidator.valid(employee.getEmail())) {
      errors.rejectValue("email", "Pattern.userForm.email");
    }
  }
}
