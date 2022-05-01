package com.learn.datajpa.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

/****************************************************************************************************
 * User: Ved Singh
 * Date: 4/25/22 9:42 PM
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 *****************************************************************************************************/

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("EMPLOYEE")
public class EmployeeVO implements Serializable {

    @PrimaryKey
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Double salary;

}
