package Bob_R;

import Bob_R.config.CommentConfig;
import Bob_R.model.Comment;
import Bob_R.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setText("Johnson");
        System.out.println("Spring Framework");

        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
