package com.learn.datajpa.cassandra.service;

import com.learn.datajpa.cassandra.mapper.EmployeeMapper;
import com.learn.datajpa.cassandra.model.EmployeeRequest;
import com.learn.datajpa.cassandra.model.EmployeeVO;
import com.learn.datajpa.cassandra.repository.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.DateTimeException;

/****************************************************************************************************
 * User: Ved Singh
 * Date: 4/25/22 9:49 PM
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 *****************************************************************************************************/

@Service
public class EmployeeService {

    private static final Logger logger = LogManager.getLogger(EmployeeService.class);
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, timeout = -1, readOnly = true, rollbackFor = RuntimeException.class, noRollbackFor = DateTimeException.class)
    public EmployeeRequest insertEmployee(EmployeeRequest request) {

        EmployeeVO employeeVO = EmployeeMapper.INSTANCE.map(request);
        logger.info("Mapping EmployeeRequest -> EmployeeVO completed: ID: {}, FirstName: {}", employeeVO.getId(), employeeVO.getFirstName());

        employeeRepository.deleteAll();
        employeeVO = employeeRepository.save(employeeVO);
        logger.info("{} Employee Added.", employeeRepository.count());

        EmployeeRequest employeeRequest = EmployeeMapper.INSTANCE.map(employeeVO);
        logger.info("Mapping EmployeeVO -> EmployeeRequest completed: ID: {}, FirstName: {}", employeeRequest.getEmployeeId(), employeeRequest.getFirstName());

        return employeeRequest;
    }

}