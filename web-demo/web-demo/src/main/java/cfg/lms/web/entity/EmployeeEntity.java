package cfg.lms.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(schema = "derby", name = "employee")
public class EmployeeEntity {
	@Id
	private int empId;
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private double salary;
}
