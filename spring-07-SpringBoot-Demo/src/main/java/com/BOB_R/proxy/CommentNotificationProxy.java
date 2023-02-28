package com.BOB_R.proxy;

import com.BOB_R.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
