/**
 * Controller class for managing employee data REST API endpoints.
 */
package pita.b2.rest_hk.employee_data_restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pita.b2.rest_hk.employee_data_restapi.model.EmployeeModel;
import pita.b2.rest_hk.employee_data_restapi.service.serviceImpl.EmployeeServiceImpl;

@Api(tags = "Employee Controller List")
@RestController
public class StartController {
    
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;    
    
    /**
     * Endpoint to retrieve all employee data.
     * @return List of EmployeeModel objects representing all employee data.
     */
    @RequestMapping(value = {"allEmployee"}, method= RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<EmployeeModel> index() {
        return employeeServiceImpl.selectAllData();
    }
    
    /**
     * Endpoint to add new employee data.
     * @param employee The EmployeeModel object representing the new employee data.
     * @param bindResult BindingResult object for validating the input.
     * @return ResponseEntity containing the result of the operation.
     */
    @RequestMapping(value = {"employeeDataAdd"}, method= RequestMethod.GET ,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> addEmployee(@Valid @RequestBody EmployeeModel employee, BindingResult bindResult) {
        if (bindResult.hasErrors()) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
            errorResponse.put("message", "validation error");
            errorResponse.put("errors", bindResult.getFieldError());
            
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        int result = employeeServiceImpl.employeeDataAdd(employee);
        Map<String, Object> successResponse = new HashMap<>();
        successResponse.put("status", HttpStatus.OK.value());
        successResponse.put("message", "Employee Added Successfully");
        successResponse.put("result", result);
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
    
    /**
     * Endpoint to delete an employee data by employee ID.
     * @param employeeId The ID of the employee to delete.
     * @return Integer representing the result of the operation.
     */
    @RequestMapping(value = "employeeDataDelete",method= RequestMethod.GET , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public int deleteEmployee(@PathVariable("employeeId") int employeeId) {
        return employeeServiceImpl.deleteEmployee(employeeId);
    }
    
    /**
     * Endpoint to update employee data by employee ID.
     * @param employeeId The ID of the employee to update.
     * @param employeeModel The updated EmployeeModel object.
     * @return Integer representing the result of the operation.
     */
    @RequestMapping(value= {"employeeDataUpdate"},method= RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public int updateProcess(@PathVariable("employeeId") int employeeId,@RequestBody EmployeeModel employeeModel) {
        return employeeServiceImpl.updateProcess(employeeId, employeeModel);
    }
    
    /**
     * Endpoint to search for employees by name.
     * @param employeeName The name of the employee to search for.
     * @return List of EmployeeModel objects matching the search criteria.
     */
     @RequestMapping(value = "searchByName",method= RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseBody   
     public List<EmployeeModel> searchByName(@ModelAttribute(name = "employeeName") String employeeName) {
            return employeeServiceImpl.searchByName(employeeName);
        }
     
    /**
     * Endpoint to search for an employee by ID.
     * @param employeeId The ID of the employee to search for.
     * @return List of EmployeeModel objects matching the search criteria.
     */
     @RequestMapping(value = "searchById",method= RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseBody   
     public List<EmployeeModel> searchById(@PathVariable("employeeId") int employeeId) {
            return employeeServiceImpl.searchByIds(employeeId);
        }

    
}
