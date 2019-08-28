package com.paloit.demo.SimpleApp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.paloit.demo.SimpleApp.model.Employee;
import com.paloit.demo.SimpleApp.service.EmployeeService;
import com.paloit.demo.SimpleApp.validator.EmployeeFormValidator;

@Controller
public class EmployeeController {

  private final EmployeeService employeeService;
  private final EmployeeFormValidator employeeFormValidator;

  public EmployeeController(final EmployeeService employeeService, EmployeeFormValidator employeeFormValidator) {
    this.employeeService = employeeService;
    this.employeeFormValidator = employeeFormValidator;
  }

  @RequestMapping("/")
  public String getEmployees(Model model) {
    Iterable<Employee> employeeList = employeeService.getAllEmployess();
    model.addAttribute("employeeList", employeeList);
    return "/views/employeeList.jsp";
  }

  @RequestMapping(value = "/employee", method = RequestMethod.POST)
  public String save(@ModelAttribute("employeeForm") @Validated Employee employee,
      BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

    if (result.hasErrors()) {
      return "employee/form";
    } else {

      employeeService.saveEmployee(employee);
      // Add message to flash scope
      redirectAttributes.addFlashAttribute("css", "success");
      redirectAttributes.addFlashAttribute("msg", "Employee added successfully!");

      return "redirect:/employees/" + employee.getId();
    }
  }

  @RequestMapping(value = "/employees/add", method = RequestMethod.GET)
  public String showAddEmployeeForm(Model model) {
    Employee employee = new Employee();
    // set default value
    employee.setFullname("John Doe");
    model.addAttribute("employeeForm", employee);
    return "/views/employeeForm.jsp";
  }

  @RequestMapping(value = "/employees/{id}/update", method = RequestMethod.GET)
  public String showUpdateEmployeeForm(@PathVariable("id") int id, Model model) {

    Employee employee = employeeService.findEmployeeById(id);
    model.addAttribute("employeeForm", employee);

    return "/views/employeeForm.jsp";
  }

  @RequestMapping(value = "/employees/{id}/delete", method = RequestMethod.GET)
  public String deleteEmployee(@PathVariable("id") int id,
      final RedirectAttributes redirectAttributes) {

    Employee employee = employeeService.findEmployeeById(id);
    employeeService.deleteEmployee(employee);

    redirectAttributes.addFlashAttribute("css", "success");
    redirectAttributes.addFlashAttribute("msg", "User is deleted!");

    return "redirect:/";

  }

  @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
  public String showEmployee(@PathVariable("id") int id, Model model) {

    Employee employee = employeeService.findEmployeeById(id);
    if (employee == null) {
      model.addAttribute("css", "danger");
      model.addAttribute("msg", "User not found");
    }
    model.addAttribute("employee", employee);

    return "/views/show.jsp";
  }

  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public String showFindEmployeeForm() {
    return "/views/findEmployee.jsp";
  }

  @RequestMapping(value = "/findEmployee", method = RequestMethod.GET)
  public ModelAndView findEmployeeFromDate(@RequestParam("dateRef") String dateRef,
      @RequestParam("arrivalDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date arrivalDate) {
    ModelAndView model = new ModelAndView();
    List<Employee> employeeList = new ArrayList<Employee>();
    if ("before".equals(dateRef)) {
      employeeList = employeeService.getEmployeesBeforeDate(arrivalDate);
    } else if ("after".equals(dateRef)) {
      employeeList = employeeService.getEmployeesAfterDate(arrivalDate);
    }

    model.addObject("employeeList", employeeList);
    model.setViewName("/views/foundEmployees.jsp");
    return model;
  }

  @InitBinder
  protected void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    binder.setValidator(employeeFormValidator);
  }

}
