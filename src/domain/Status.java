package domain;

/**
 * Created with IntelliJ IDEA.
 * domain.User: sujan.sarkar
 * Date: 4/28/14
 * Time: 2:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Status {
    private String userId;
    private String status;
    private String statusId;

    public Status(String userId, String status) {
        this.userId = userId;

        this.status = status;

    }

    public String getUserId() {
        return this.userId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

}
