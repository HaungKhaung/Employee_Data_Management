package pita.b2.rest_hk.employee_data_restapi.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class EmployeeModel {

	@Getter
	@Setter
	private int employeeId;

	@Getter
	@Setter
	@NotBlank(message = "Please enter employee name")
	private String employeeName;

	@Getter
	@Setter
	@NotNull(message = "Please enter employee age")
	private int employeeAge;

	@Getter
	@Setter
	@NotBlank(message = "Please enter employee address")
	private String employeeAddress;
	
	@Getter
	@Setter
	@Email(message = "Please enter valid email")
	@NotBlank(message = "Please enter employee email")
	private String employeeEmail;
	
	@Getter
	@Setter
	@NotBlank(message = "Please enter employee phone")
	private String employeePhone;
	
	@Getter
	@Setter
	private String employeePosition;
	
	
	
}
