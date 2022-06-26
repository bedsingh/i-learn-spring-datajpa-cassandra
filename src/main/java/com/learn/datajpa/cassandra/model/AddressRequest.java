package com.learn.datajpa.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/****************************************************************************************************
 * Date: 5/8/22 2:39 PM | Author: Singh, Ved |
 * To change this template user | Preferences | Editor | File and Code Templates | Includes tab
 *
 *****************************************************************************************************/

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class AddressRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long addressId;

    @NotBlank(message = "Street is empty.")
    private String street;

    @NotBlank(message = "Unit is empty.")
    private String unit;

    @NotNull
    private String city;

    @NotBlank(message = "State is empty.")
    @Size(min = 2, max = 2, message = "State code must be 2 chars.")
    private String state;

    @Positive(message = "ZipCode should be > 0")
    @Min(value = 5, message = "ZipCode should >= 5")
    @Max(value = 10, message = "ZipCode should <= 10")
    private Integer zipCode;

    @NotBlank(message = "Country is empty.")
    @Size(min = 3, max = 56, message = "country must be >=3 and <= 50")
    private String country;

    @Pattern(regexp = "CURRENT|PERMANENT|MAILING|PREVIOUS", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Any of CURRENT|PERMANENT|MAILING|PREVIOUS required.")
    private String addressType;

}

