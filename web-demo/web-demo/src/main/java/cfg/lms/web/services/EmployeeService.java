package cfg.lms.web.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cfg.lms.web.entity.EmployeeEntity;
import cfg.lms.web.repository.EmployeeRepository;
import cfg.lms.web.services.bo.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> fetchEmployeeData() {
		List<EmployeeEntity> entites = employeeRepository.findAll();
		return entites.stream().map(e -> {
			Employee emp = new Employee();
			emp.setId(e.getEmpId());
			emp.setName(e.getName());
			return emp;
		}).collect(Collectors.toList());
	}

	public Employee fetchEmployeeDataById(int id) {
		Optional<EmployeeEntity> entityopt = employeeRepository.findById(id);
		 if (entityopt.isPresent()) {
		        EmployeeEntity e = entityopt.get();
		        Employee emp = new Employee();
		        emp.setName(e.getName());
		        emp.setSalary(e.getSalary());
		        return emp;
		    } else {
		        return null;
		    }
	}

// // Get all employees
//    public List<Employee> getAllEmployees() {
//        return employeeRepository.findAll();
//    }
//
//    // Get employee by ID
//    public Optional<Employee> getEmployeeById(int id) {
//        return employeeRepository.findById(id);
//    }
}
