package Bob_R.service;

import Bob_R.model.Comment;
import Bob_R.proxy.CommentNotificationProxy;
import Bob_R.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
   // @Autowired
    /// don`t forget to write final make sure that constructor correct adn added
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
   // @Autowired
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
   /// WHEN WE CREATE CONSTRUCTOR IT WILL BE AUTOMATIC    @Autowired
    public CommentService(CommentRepository commentRepository,/*@Qualifier("emailCommentNotificationProxy")*/ CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }
}
