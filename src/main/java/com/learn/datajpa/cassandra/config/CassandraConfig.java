package com.learn.datajpa.cassandra.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractSessionConfiguration;

/****************************************************************************************************
 * Date: 4/25/22 10:15 PM | Author: Ved Singh |
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 *****************************************************************************************************/

@Configuration
public class CassandraConfig extends AbstractSessionConfiguration {

    @Bean
    public CqlSession session() {
        return CqlSession.builder().withKeyspace("emp_db_keyspace").build();
    }

    @Override
    protected String getKeyspaceName() {
        return "emp_db_keyspace";
    }

    @Override
    protected String getLocalDataCenter() {
        return "datacenter1";
    }


    /*

  @Value("${spring.data.cassandra.contact-points:placeholder}")
  private String contactPoints;

  @Value("${spring.data.cassandra.port:0000}")
  private int port;

  @Value("${spring.data.cassandra.keyspace:placeholder}")
  private String keySpace;

  @Value("${spring.data.cassandra.username}")
  private String username;

  @Value("${spring.data.cassandra.password}")
  private String password;

  @Value("${spring.data.cassandra.schema-action}")
  private String schemaAction;

  @Override
  protected String getKeyspaceName() {
    return keySpace;
  }

  @Override
  protected String getContactPoints() {
    return contactPoints;
  }

  @Override
  protected int getPort() {
    return port;
  }

  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.valueOf(schemaAction);
  }

  @Override
  protected AuthProvider getAuthProvider() {
    return new PlainTextAuthProvider(username, password);
  }
     */

}
