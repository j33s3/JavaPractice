/*
 * @file            SpringBoot/src/main/java/com/TaskApiApplication.java
 * @author          Jesse Peterson
 * @createTime      2025-04-11 22:05:56
 * @lastModified    2025-04-11 21:45:52
*/

package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Bundles 3 annotations into 1 (@configuration, @EnableAutoConfiguration, @ComponentScan)
// Marks this class as source of bean definitions (Where spring should look for configurations)
// Tells boot to automatically configure beans based on the dependencies (spring web = tomcat)
// Tells spring to scan this package and its subpackages for components, services, controller and so forth
@SpringBootApplication
public class TaskApiApplication {


    /**
     * This is the main method but tailored to spring boot
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(TaskApiApplication.class, args);
    }
    
}
