package net.tihz;

import net.tihz.controller.FeedbackController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Application {

    public static void main(String[] args) {
        Class<?>[] source = new Class[] {Application.class, IndexController.class, FeedbackController.class};
        SpringApplication.run(source, args);
    }
}
