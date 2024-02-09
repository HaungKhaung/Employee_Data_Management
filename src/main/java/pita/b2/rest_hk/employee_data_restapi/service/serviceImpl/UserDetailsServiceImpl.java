package pita.b2.rest_hk.employee_data_restapi.service.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pita.b2.rest_hk.employee_data_restapi.model.AccountModel;
import pita.b2.rest_hk.employee_data_restapi.repository.LoginRepository;



@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private LoginRepository loginRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountModel accountModel = loginRepository.loginProcess(username);
		return new User(accountModel.getUsername(), accountModel.getPassword(), new ArrayList<>());
	}
}
