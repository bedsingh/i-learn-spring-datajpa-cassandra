package com.learn.datajpa.cassandra;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**********************************************************************************************************
 * Date: 04/25/2022 8:43 PM | Author: Singh, Ved |
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 **********************************************************************************************************/

@SpringBootApplication
public class SpringDataJpaCassandraApplication extends SpringBootServletInitializer {

    private static final Logger logger = LogManager.getLogger(SpringDataJpaCassandraApplication.class);
    private static final String DASH_LINE = "-----------------------------------------------------------------------------";

    public static void main(String[] args) {
        ConfigurableApplicationContext context;
        printStartEndLog("********* Spring Data JPA Cassandra Application Starting ********************");
        context = SpringApplication.run(SpringDataJpaCassandraApplication.class, args);
        printBeans(context);
        printStartEndLog("********* Spring Data JPA Cassandra Application Started Successfully ********");
    }

    private static void printBeans(ConfigurableApplicationContext context) {
        String [] beans = context.getBeanDefinitionNames();
        AtomicInteger counter = new AtomicInteger(0);
        logger.info("Total {} beans object created in spring container.", beans.length);
        Arrays.stream(beans).sorted()
                .forEach(beanName -> {
                    logger.debug("{}) Bean name: {}", counter.incrementAndGet(), beanName);
        });
    }

    private static void printStartEndLog(String message) {
        logger.info(DASH_LINE);
        logger.info(message);
        logger.info(DASH_LINE);
    }

}
