package com.learn.datajpa.cassandra.resource;

import com.learn.datajpa.cassandra.config.GitPropertyConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;

/****************************************************************************************************
 * Date: 6/25/22 11:02 PM | Author: Singh, Ved |
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 *****************************************************************************************************/

@Resource
@Path("/git-commit-info")
public class GitCommitInfoResource {

    private static final Logger logger = LogManager.getLogger(GitCommitInfoResource.class);
    private final GitPropertyConfig gitProperty;

    @Autowired
    public GitCommitInfoResource(GitPropertyConfig gitProperty) {
        this.gitProperty = gitProperty;
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Response getCommitIdInfo() {
        logger.info("Calling getCommitIdInfo method...");
        var result = new HashMap<>();
        result.put("git-branch", gitProperty.getBranch());
        result.put("git-build", gitProperty.getBuild());
        result.put("git-commit", gitProperty.getCommit());
        result.put("git-remote-url", gitProperty.getRemoteOriginUrl());
        result.put("git-total-commit", gitProperty.getTotalCommitCount());

        return Response.status(200)
                .entity(result)
                .contentLocation(URI.create("/git-commit-info"))
                .build();
    }

}
