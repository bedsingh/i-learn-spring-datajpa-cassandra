package com.learn.datajpa.cassandra.config;

import com.learn.datajpa.cassandra.exception.AppBadRequestException;
import com.learn.datajpa.cassandra.exception.UncaughtException;
import com.learn.datajpa.cassandra.resource.EmployeeResource;
import com.learn.datajpa.cassandra.resource.GitCommitInfoResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/****************************************************************************************************
 * User: Ved Singh
 * Date: 4/25/22 10:53 PM
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 *****************************************************************************************************/

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(EmployeeResource.class);
        register(AppBadRequestException.class);
        register(UncaughtException.class);
        register(GitCommitInfoResource.class);
    }
    
}
