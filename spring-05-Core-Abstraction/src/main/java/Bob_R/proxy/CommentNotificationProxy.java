package Bob_R.proxy;


import Bob_R.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
