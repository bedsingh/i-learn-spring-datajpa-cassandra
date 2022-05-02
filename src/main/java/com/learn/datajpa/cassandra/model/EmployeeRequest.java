package com.learn.datajpa.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/****************************************************************************************************
 * Date: 5/1/22 11:57 AM | Author: Singh, Ved |
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 *****************************************************************************************************/

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class EmployeeRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long employeeId;

    @NotBlank(message="First name is empty.")
    @Size(min = 3, max = 50, message = "First name must be > 2 and < 51 chars.")
    private String firstName;

    @NotNull(message="Last name is empty.")
    private String lastName;

    @Email(message = "Valid email is required.")
    private String email;

    @NotNull(message="Salary is empty.")
    private Double salary;

    @NotNull
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}")
    private String phoneNumber;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
