package pita.b2.rest_hk.employee_data_restapi.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pita.b2.rest_hk.employee_data_restapi.model.EmployeeModel;


public interface EmployeeService {
	public int employeeDataAdd(EmployeeModel employeeModel);
	public int deleteEmployee(int employeeId);
	public int updateProcess(@Param("employeeId")int employeeId, @Param("employeeModel") EmployeeModel employeeModel);
	public List<EmployeeModel> selectAllData();
	public List<EmployeeModel> searchByName(String employeeName);
	public List<EmployeeModel> searchByIds(int employeeId);
}
