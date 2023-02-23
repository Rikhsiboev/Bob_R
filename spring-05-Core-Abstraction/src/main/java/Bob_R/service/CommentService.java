package Bob_R.service;

import Bob_R.model.Comment;
import Bob_R.proxy.CommentNotificationProxy;
import Bob_R.repostory.CommentRepository;
import Bob_R.repostory.DBCommentRepository;

public class CommentService {
    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }


}
