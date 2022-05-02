# Read Me First
The following was discovered as part of building this project:

* The original package name 'i-learn-spring-datajpa-cassandra' is invalid and this project uses 'ilearnspringdatajpacassandra' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.7/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.7/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-developing-web-applications)
* [Jersey](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-jersey)
* [Spring Data for Apache Cassandra](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#boot-features-cassandra)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.6.7/reference/htmlsingle/#configuration-metadata-annotation-processor)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Spring Data for Apache Cassandra](https://spring.io/guides/gs/accessing-data-cassandra/)

## Cassandra Installation Steps

These steps are for MacOS
Before install Cassandra make sure, you have jdk 11 as Cassandra 4.0.3 version support only this version.
Open the terminal and type the below command, also Cassandra
* $ cd ~
* $ brew install cassandra

Once above command executes successfully, you will see installation path such as:  
/opt/homebrew/Cellar/cassandra/4.0.3_1  
Default username and password are cassandra  
More Info:  
https://cassandra.apache.org/doc/latest/cassandra/new/java11.html

Create .bashrc file in your home directory and use environments path as:  
vi ~/.bashrc  
export CASSANDRA_USE_JDK11=true  
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.15.jdk/Contents/Home/  
export PATH=$PATH:$JAVA_HOME/bin

Important commands
* $ cqlsh --version
* $ brew services start cassandra
* $ brew services stop cassandra
* $ /opt/homebrew/opt/cassandra/bin/cassandra -f    &nbsp; &nbsp; &nbsp; (start service in background)


Now Execute CQL (Cassandra Query Language):
CQL Help:  
https://docs.spring.io/spring-data/cassandra/docs/current/reference/html/  
https://docs.datastax.com/en/cql-oss/3.3/cql/cql_using/useQuerySystemTable.html  
https://www.tutorialspoint.com/cassandra/cassandra_create_keyspace.htm

```roomsql
$ cqlsh  

cqlsh> use system;
cqlsh:system> SELECT data_center FROM local;
    
data_center
-------------
datacenter1 

cqlsh> CREATE KEYSPACE datajpa_keyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

cqlsh> select * from emp_db_keyspace.employee;

 id                 | firstname | lastname | salary
--------------------+-----------+----------+--------
 138707137847080002 |      Ved4 |    Singh |    400
 138707137847080000 |      Ved2 |    Singh |    200
 138707137846950000 |      Ved1 |    Singh |    100
 138707137847080001 |      Ved3 |    Singh |    300

(4 rows)
cqlsh>     
``` 

```yaml
# Spring Cassandra Database Configuration in application.yml file
spring:
  output:
    ansi:
      enabled: always
  data:
    cassandra:
      local-datacenter: datacenter1
      keyspace-name: emp_db_keyspace
      port: 9042
      username: cassandra
      password: cassandra
      schema-action: create_if_not_exists
      contact-points:
        - localhost:9042
        - 127.0.0.1:9042
```

* Valid Employee Request sample:   
```json
{
    "firstName": "Ved",
    "lastName": "Singh",
    "email": "ved.singh.007@hotmail.com",
    "salary": 1230.98,
    "phoneNumber":"444-999-1111"
}
```
* Valid Employee Response sample:
```json
{
  "employeeId": 138707557315760000,
  "firstName": "Ved",
  "lastName": "Singh",
  "email": "ved.singh.007@hotmail.com",
  "salary": 1230.98,
  "phoneNumber": "444-999-1111"
}
```

* Invalid Employee Request sample:
```json
{
  "firstName": "VS",
  "lastName": "Singh",
  "email": "ved.singh.007@hotmail.com",
  "salary": 1230.98,
  "phoneNumber":"444-9991111"
}
```

* Invalid Employee Response sample:
```json
{
    "httpStatus": 400,
    "message": "createEmployee.employeeRequest.firstName: First name must be > 2 and < 51 chars., createEmployee.employeeRequest.phoneNumber: must match \"\\d{3}-\\d{3}-\\d{4}\"",
    "code": 10001,
    "developerMessage": {
        "createEmployee.employeeRequest.firstName": "First name must be > 2 and < 51 chars.",
        "createEmployee.employeeRequest.phoneNumber": "must match \"\\d{3}-\\d{3}-\\d{4}\""
    }
}
```