package domain;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 4/29/14
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Like {
    private String id;
    private String userId;

    public Like(String id, String userId) {
        this.id = id;
        this.userId = userId;

    }

    public String getId() {
        return this.id;
    }

    public String getUserId() {
        return this.userId;
    }
}
