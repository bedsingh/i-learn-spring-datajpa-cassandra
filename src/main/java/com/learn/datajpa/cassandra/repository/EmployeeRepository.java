package com.learn.datajpa.cassandra.repository;

import com.learn.datajpa.cassandra.entity.EmployeeEntity;
import com.learn.datajpa.cassandra.entity.EmployeeKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/****************************************************************************************************
 * User: Ved Singh
 * Date: 4/25/22 9:41 PM
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 *****************************************************************************************************/

@Repository
public interface EmployeeRepository extends CassandraRepository<EmployeeEntity, EmployeeKey> {

}
