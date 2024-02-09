package pita.b2.rest_hk.employee_data_restapi.repository;

import org.springframework.stereotype.Repository;

import pita.b2.rest_hk.employee_data_restapi.model.AccountModel;

@Repository
public interface LoginRepository {
	public AccountModel loginProcess(String username);
}

