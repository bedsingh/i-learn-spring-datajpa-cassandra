package com.learn.datajpa.cassandra.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Map;

/****************************************************************************************************
 * Date: 6/26/22 9:11 AM | Author: Singh, Ved |
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 * This class is used to read the git-commit.properties file
 *****************************************************************************************************/

@Getter
@Setter
@Configuration
//@PropertySources({ @PropertySource("classpath:git-commit.properties") })
@ConfigurationProperties(prefix = "git")
public class GitPropertyConfig {

    private String branch;
    private Map<String, String> build;
    private Map<String, String> commit;

    @Value("${git.remote.origin.url}")
    private String remoteOriginUrl;

    @Value("${git.total.commit.count}")
    private Integer totalCommitCount;
}
