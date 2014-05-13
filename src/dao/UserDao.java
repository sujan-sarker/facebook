package dao;

import domain.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * domain.User: sujan.sarkar
 * Date: 4/28/14
 * Time: 1:17 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    public void addUser(User user);

    public void addStatus(Status status);

    public void addFriend(FriendList friendList);

    public List<FriendList> getMutualFriendList(String id, String friendId);

    public void addComment(Comment comment);

    public void likeStatus(Like like);

    public void likeComment(Like like);
}
