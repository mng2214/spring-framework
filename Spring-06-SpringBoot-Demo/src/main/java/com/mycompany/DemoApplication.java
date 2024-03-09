package com.mycompany;

import com.mycompany.model.Comment;
import com.mycompany.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {


        Comment comment = new Comment();
        comment.setAuthor("Artur");
        comment.setText("Spring Framework");

        ApplicationContext context =  SpringApplication.run(DemoApplication.class, args);

        CommentService sc = context.getBean(CommentService.class);

        sc.publishComment(comment);
    }

}
