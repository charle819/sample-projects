package com.exampleZone.SpringMVCJavaBased.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exampleZone.SpringMVCJavaBased.dao.EmployeeDao;
import com.exampleZone.SpringMVCJavaBased.model.Employee;

@Service
@Transactional
public class EmployeeService {

	private final Logger LOGGER = Logger.getLogger(EmployeeService.class.getName());

	@Autowired
	private EmployeeDao empDao;

	public List<Employee> getAllEmployees() {
		// return eList;
		return empDao.getAllEmployees();
	}

	public Employee getEmployeeById(long id) {

		return empDao.findEmployeeById(id);
	}

	public boolean checkEmployeeExist(long id) {
		if (getEmployeeById(id) != null) {
			LOGGER.info("Employee with Id : " + id + " exist ");
			return true;
		}
		LOGGER.warning("Employee with Id : " + id + " does not exist");
		return false;
	}

	public void addEmployee(Employee e) {

		empDao.saveEmployee(e);
		LOGGER.info("employee " + e.getE_name() + " was added successfully");
	}

	public void deleteEmpoyeeById(long id) {

		empDao.deleteEmployee(id);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void updateEmployee(Employee updateEmp) {
		long id = updateEmp.getE_id();
		Employee e = empDao.findEmployeeById(id);
		if (e != null) {
			e.setE_name(updateEmp.getE_name());
			e.setE_role(updateEmp.getE_role());
			e.setE_address(updateEmp.getE_address());
			e.setE_contactNo(updateEmp.getE_contactNo());
			e.setE_emailId(updateEmp.getE_emailId());
		}

		LOGGER.info("Employee with id : " + updateEmp.getE_id() + " was update successfully");

	}

}
