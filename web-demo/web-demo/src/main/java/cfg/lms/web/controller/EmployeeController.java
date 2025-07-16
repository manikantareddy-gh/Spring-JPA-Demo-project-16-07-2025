package cfg.lms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cfg.lms.web.services.EmployeeService;
import cfg.lms.web.services.bo.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/fetch-all")
	public ResponseData fetchEmployeeData() {
		ResponseData output = new ResponseData();
		List<Employee> employees = employeeService.fetchEmployeeData();
		output.setData(employees);
		output.setStatus("success");
		return output;
	}

	@GetMapping("/fetch-by-id/{id}")
	public ResponseData fetchEmployeeDataById(@PathVariable("id") int id) {
		ResponseData output = new ResponseData();
		Employee employee = employeeService.fetchEmployeeDataById(id);

		if (employee != null) {
			output.setData(employee);
			output.setStatus("success");
		} else {
			output.setStatus("failed");
			output.setMessage("Employee not found with ID: " + id);
		}
		return output;
	}
}

//@GetMapping("/fetch-employees")
//public List<Employee> fetchEmployeeData() {
//  return employeeService.fetchEmployeeData();
//}

//@GetMapping("/fetch-employee-by-id/{id}")
//public Employee fetchEmployeeDataById(@PathVariable("id") int id) {
//  return employeeService.fetchEmployeeDataById(id);
//}
//

// GET all employees
//@GetMapping("/get-employees")
//public List<Employee> getAllEmployees() {
//  return employeeService.getAllEmployees();
//}
//
// GET employee by ID
//@GetMapping("/get-employee-by-id/{id}")
//public Optional<Employee> getEmployeeById(@PathVariable("id") int id) {
//  return employeeService.getEmployeeById(id);
//}
