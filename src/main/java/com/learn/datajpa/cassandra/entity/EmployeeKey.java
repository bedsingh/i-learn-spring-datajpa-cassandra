package com.learn.datajpa.cassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

/****************************************************************************************************
 * Date: 5/8/22 3:53 PM | Author: Singh, Ved |
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 * This is the primary key column class for Employee table. similar like a composite key in oracle.
 *
 *****************************************************************************************************/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyClass
public class EmployeeKey implements Serializable {

    @PrimaryKeyColumn(name = "EMP_ID", type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    private Long id;

    @PrimaryKeyColumn(name = "FIRST_NAME", ordinal = 0)
    private String firstName;

    @PrimaryKeyColumn(name = "LAST_NAME", ordinal = 1)
    private String lastName;

    @PrimaryKeyColumn(name = "EMAIL", ordinal = 2)
    private String email;

}
