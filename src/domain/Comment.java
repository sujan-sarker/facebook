package domain;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 4/29/14
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class Comment {
    private String statusId;
    private String commentId;
    private String userId;
    private String comment;

    public Comment(String statusId, String userId, String comment) {
        this.statusId = statusId;
        this.userId = userId;
        this.comment = comment;

    }

    public String getComment() {

        return this.comment;
    }

    public String getUserId() {

        return this.userId;
    }

    public String getStatusId() {
        return this.statusId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;

    }
}
