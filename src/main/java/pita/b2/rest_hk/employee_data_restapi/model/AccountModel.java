package pita.b2.rest_hk.employee_data_restapi.model;

import lombok.Getter;
import lombok.Setter;

public class AccountModel {

	@Getter
	@Setter
	private String username;
	
	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	private boolean isEnabled;
	
	@Getter
	@Setter
	private String authority;
}
