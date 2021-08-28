package com.larkas.springit;

import com.larkas.springit.config.SpringitProperties;
import com.larkas.springit.domain.Comment;
import com.larkas.springit.domain.Link;
import com.larkas.springit.repository.CommentRepository;
import com.larkas.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
        System.out.println("testar lite bara i main");
        log.info("testar loggen i main");
    }

    //@Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("Getting started with sp boot 2", "https://gd.se/");
            linkRepository.save(link);

            Comment comment = new Comment("this link is great", link);
            commentRepository.save(comment);
            link.addComment(comment);

            System.out.println("link comments:");
            link.getComments().forEach(c -> System.out.println(c.getBody()));
        };
    }

//    @Bean
//    CommandLineRunner runner() {
//        return args -> {
//            log.error("error message");
//            log.warn("warning message");
//            log.info("info message");
//            log.debug("debug message");
//            log.trace("trace message");
//        };
//    }

//    @Bean
//    CommandLineRunner runner() {
//        return args -> {
//            log.error("error message");
//            log.warn("warning message");
//            log.info("info message");
//            log.debug("debug message");
//            log.trace("trace message");
//        };
//    }

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
