package pita.b2.rest_hk.employee_data_restapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import pita.b2.rest_hk.employee_data_restapi.model.EmployeeModel;


@Repository
public interface EmployeeRepository {
	public int employeeDataAdd(EmployeeModel employeeModel);
	public int deleteEmployee(int employeeId);
	public int updateProcess(@Param("employeeId")int employeeId, @Param("employeeModel") EmployeeModel employeeModel);
	public List<EmployeeModel> selectAllData();
	public List<EmployeeModel> searchByName(String employeeName);
	public List<EmployeeModel> searchByIds(int employeeId);
	
}
