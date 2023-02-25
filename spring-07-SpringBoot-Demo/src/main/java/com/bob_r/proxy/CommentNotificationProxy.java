package com.bob_r.proxy;

import com.bob_r.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
