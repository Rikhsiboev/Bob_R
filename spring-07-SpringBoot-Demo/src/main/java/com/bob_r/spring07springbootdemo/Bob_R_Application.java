package com.bob_r.spring07springbootdemo;
import com.bob_r.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.bob_r.model.Comment;

@SpringBootApplication
public class Bob_R_Application {

    public static void main(String[] args) {


        Comment comment  = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        SpringApplication.run(Bob_R_Application.class, args);

//        CommentService commentService = container.getBean(CommentService.class);
//        commentService.publishComment(comment);
//
//        commentService.printConfigData();
//        commentService.printDbConfigData();
    }

}
