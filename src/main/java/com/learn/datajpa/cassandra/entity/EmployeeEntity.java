package com.learn.datajpa.cassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.cassandra.core.mapping.Column;
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
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private EmployeeKey employeeKey;

    @Column("SALARY")
    private Double salary;

    @Column("AGE")
    private Integer age;

    @Column("PHONE_NUMBER")
    private String phoneNumber;

}
