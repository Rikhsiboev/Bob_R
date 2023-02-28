package com.BOB_R;
import com.BOB_R.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.BOB_R.model.Comment;

@SpringBootApplication
public class Bob_R_Application {

    public static void main(String[] args) {


        Comment comment  = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");


        ApplicationContext container =  SpringApplication.run(Bob_R_Application.class, args);

        CommentService commentService = container.getBean(CommentService.class);
        commentService.publishComment(comment);

        commentService.printConfigData();
        commentService.printDbConfigData();
    }

}
