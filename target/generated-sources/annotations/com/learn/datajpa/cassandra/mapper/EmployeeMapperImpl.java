package com.learn.datajpa.cassandra.mapper;

import com.learn.datajpa.cassandra.model.EmployeeRequest;
import com.learn.datajpa.cassandra.model.EmployeeVO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-01T16:59:59-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeVO map(EmployeeRequest employeeRequest) {
        if ( employeeRequest == null ) {
            return null;
        }

        EmployeeVO employeeVO = new EmployeeVO();

        employeeVO.setId( getEmployeeId( employeeRequest.getEmployeeId() ) );
        employeeVO.setFirstName( employeeRequest.getFirstName() );
        employeeVO.setLastName( employeeRequest.getLastName() );
        employeeVO.setEmail( employeeRequest.getEmail() );
        employeeVO.setSalary( employeeRequest.getSalary() );

        return employeeVO;
    }

    @Override
    public EmployeeRequest map(EmployeeVO employeeVO) {
        if ( employeeVO == null ) {
            return null;
        }

        EmployeeRequest employeeRequest = new EmployeeRequest();

        employeeRequest.setEmployeeId( getEmployeeId( employeeVO.getId() ) );
        employeeRequest.setFirstName( employeeVO.getFirstName() );
        employeeRequest.setLastName( employeeVO.getLastName() );
        employeeRequest.setEmail( employeeVO.getEmail() );
        employeeRequest.setSalary( employeeVO.getSalary() );

        return employeeRequest;
    }
}
