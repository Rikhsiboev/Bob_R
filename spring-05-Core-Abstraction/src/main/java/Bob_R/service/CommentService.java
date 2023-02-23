package Bob_R.service;

import Bob_R.model.Comment;
import Bob_R.proxy.CommentNotificationProxy;
import Bob_R.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
   // @Autowired
    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;
   // @Autowired
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
   /// WHEN WE CREATE CONSTRUCTOR IT WILL BE AUTOMATIC    @Autowired
    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }
}
