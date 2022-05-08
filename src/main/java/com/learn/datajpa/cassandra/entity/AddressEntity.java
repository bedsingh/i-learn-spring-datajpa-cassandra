package com.learn.datajpa.cassandra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

/****************************************************************************************************
 * Date: 5/8/22 3:45 PM | Author: Singh, Ved |
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 *****************************************************************************************************/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("ADDRESS")
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKeyColumn(name = "ID", type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    private Long addressId;

    @Column("STREET")
    private String street;

    @Column("UNIT")
    private String unit;

    @Column("CITY")
    private String city;

    @Column("STATE")
    private String state;

    @Column("ZIP_CODE")
    private Integer zipCode;

    @Column("COUNTRY")
    private String country;

    @Column("ADDRESS_TYPE")
    private String addressType;

}
