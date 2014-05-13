package domain;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 4/29/14
 * Time: 10:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class FriendList {
    private String id;
    private String friendId;

    public FriendList(String id, String friendId) {
        this.id = id;
        this.friendId = friendId;

    }

    public String getId() {
        return this.id;
    }

    public String getFriendId() {
        return this.friendId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
}
