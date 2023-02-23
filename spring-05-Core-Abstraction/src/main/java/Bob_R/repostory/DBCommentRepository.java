package Bob_R.repostory;

import Bob_R.model.Comment;

public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: "+comment.getText());
    }
}
