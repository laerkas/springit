package com.larkas.springit;

import com.larkas.springit.config.SpringitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
        System.out.println("testar lite bara");
        log.debug("testar loggen");
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            log.error("error message");
            log.warn("warning message");
            log.info("info message");
            log.debug("debug message");
            log.trace("trace message");
        };
    }

//    @Bean
//    @Profile("production")
//    CommandLineRunner runner() {
//        return args -> {
//            //System.out.println("Only run in production:" + springitProperties.getWelcomeMsg());
//            System.out.println("printing all the bean names in the app context");
//            System.out.println("----------------------");
//            String[] beans = applicationContext.getBeanDefinitionNames();
//            Arrays.stream(beans).sorted().forEach(s -> System.out.println(s));
////            Arrays.sort(beans);
////            for (String bean : beans) {
////                System.out.println(bean);
////
////            }
//
//        };
//    }
}
