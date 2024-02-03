package com.dba9514.RestCrud.DAO;

import com.dba9514.RestCrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
