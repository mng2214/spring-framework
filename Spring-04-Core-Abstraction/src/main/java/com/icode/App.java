package com.icode;

import com.icode.config.ProjectConfig;
import com.icode.model.Comment;
import com.icode.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Artur");
        comment.setText("Spring Framework");

        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

    }
}
