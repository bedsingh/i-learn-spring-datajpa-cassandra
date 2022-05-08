package com.learn.datajpa.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "First name is empty.")
    @Size(min = 2, max = 80, message = "First name must between 2 and 80 chars.")
    private String firstName;


    @NotEmpty(message = "Last name is empty.")
    @Size(min = 2, max = 80, message = "Last name must between 2 and 80 chars.")
    private String lastName;


    @Email(message = "Valid email is required.")
    private String email;


    @NotNull(message = "Salary is empty.")
    @PositiveOrZero(message = "Salary should be >= 0")
    @DecimalMin(value = "0.00", message = "Salary should be >= 0.0")
    @DecimalMax(value = "1000000.0", message = "Salary should be <= 1000000.00")
    private Double salary;


    @NotNull
    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}")
    private String phoneNumber;


    @NotNull
    @Min(value = 18, message = "Age should > 18")
    @Max(value = 150, message = "Age should < 150")
    private Integer age;


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
