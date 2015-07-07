package net.tihz;

import net.tihz.controller.FeedbackController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        Class<?>[] source = new Class[] {Application.class, IndexController.class, FeedbackController.class};
        SpringApplication.run(source, args);
    }
}
