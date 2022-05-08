package com.learn.datajpa.cassandra.mapper;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.learn.datajpa.cassandra.entity.EmployeeEntity;
import com.learn.datajpa.cassandra.model.EmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

/****************************************************************************************************
 * Date: 5/1/22 3:47 PM | Author: Singh, Ved |
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 * This class is used to convert from one object to another.
 *
 *****************************************************************************************************/

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "employeeKey.id", source = "employeeRequest", qualifiedByName = "mapEmployeeId")
    @Mapping(target = "employeeKey.firstName", source = "firstName")
    @Mapping(target = "employeeKey.lastName", source = "lastName")
    @Mapping(target = "employeeKey.email", source = "email")
    EmployeeEntity map(EmployeeRequest employeeRequest);

    //@InheritInverseConfiguration
    @Mapping(target = "employeeId", source = "employeeKey.id")
    @Mapping(target = "firstName", source = "employeeKey.firstName")
    @Mapping(target = "lastName", source = "employeeKey.lastName")
    @Mapping(target = "email", source = "employeeKey.email")
    EmployeeRequest map(EmployeeEntity employeeVO);


    @Named("mapEmployeeId")
    default Long getEmployeeId(EmployeeRequest employeeRequest) {
        return Optional.of(employeeRequest.hashCode())
                .map(Long::valueOf)
                .map(Math::abs)
                .orElse(Uuids.timeBased().timestamp());
    }

}
