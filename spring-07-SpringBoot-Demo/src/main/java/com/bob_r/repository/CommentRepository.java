package com.bob_r.repository;

import com.bob_r.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
