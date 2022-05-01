package com.learn.datajpa.cassandra.resource;

import com.learn.datajpa.cassandra.model.EmployeeRequest;
import com.learn.datajpa.cassandra.model.EmployeeVO;
import com.learn.datajpa.cassandra.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/****************************************************************************************************
 * User: Ved Singh
 * Date: 4/25/22 10:51 PM
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 *****************************************************************************************************/

@Resource
@Path("/employees")
public class EmployeeResource {

    private static final Logger logger = LogManager.getLogger(EmployeeResource.class);
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
    public Response createEmployee(@Valid EmployeeRequest employeeRequest) {

        logger.debug("Adding Employee Data: {}", employeeRequest);
        employeeRequest = employeeService.insertEmployee(employeeRequest);

        return Response.status(201)
                .entity(employeeRequest)
                .contentLocation(URI.create("/employees"))
                .build();
    }

}
