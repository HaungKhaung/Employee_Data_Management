package pita.b2.rest_hk.employee_data_restapi.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pita.b2.rest_hk.employee_data_restapi.model.EmployeeModel;
import pita.b2.rest_hk.employee_data_restapi.repository.EmployeeRepository;
import pita.b2.rest_hk.employee_data_restapi.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public int employeeDataAdd(EmployeeModel employeeModel) {
		return employeeRepository.employeeDataAdd(employeeModel);
	}

	@Override
	public int deleteEmployee(int employeeId) {
		return employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public int updateProcess(int employeeId,EmployeeModel employeeModel) {
		return employeeRepository.updateProcess(employeeId,employeeModel);
	}

	@Override
	public List<EmployeeModel> selectAllData() {
		return employeeRepository.selectAllData();
	}

	@Override
	public List<EmployeeModel> searchByName(String employeeName) {
		return employeeRepository.searchByName(employeeName);
	}

	@Override
	public List<EmployeeModel> searchByIds(int employeeId) {
		return employeeRepository.searchByIds(employeeId);
	}
}
