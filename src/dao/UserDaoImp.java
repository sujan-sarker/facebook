package dao;

import domain.*;
import util.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * domain.User: sujan.sarkar
 * Date: 4/28/14
 * Time: 1:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImp implements UserDao {
    private String query;

    public void addUser(User user) {
        query = "INSERT INTO `facebook`.`user_profile` (`id`, `first_name`, `last_name`,`dob`,`email`,`password`)" +
                " VALUES (?, ?, ?, ?,?,?)";

        String userId = user.getUserId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String password = user.getPassword();
        String email = user.getEmail();
        String dob = user.getDob();


        Database.insertUpdateDeleteQuery(query, userId, firstName, lastName, dob, email, password);
        Database.closeConnection();
    }

    public void addStatus(Status status) {
        query = "INSERT INTO `facebook`.`status` (`user_id`,`status`)" +
                " VALUES (?, ?)";

        String userId = status.getUserId();
        String userStatus = status.getStatus();

        Database.insertUpdateDeleteQuery(query, userId, userStatus);
        Database.closeConnection();

    }

    public void addFriend(FriendList friendList) {
        query = "INSERT INTO `facebook`.`friend_list` (`id`,`friend_id`)" +
                " VALUES (?, ?)";

        String id = friendList.getId();
        String friendId = friendList.getFriendId();
        System.out.println(friendId);

        Database.insertUpdateDeleteQuery(query, id, friendId);
        Database.insertUpdateDeleteQuery(query, friendId, id);
        Database.closeConnection();

    }

    public List<FriendList> getMutualFriendList(String id, String friendId) {

        List<FriendList> mutualFriendList = new ArrayList<FriendList>();

        query = "SELECT `friend_id` FROM `facebook`.`friend_list` WHERE `id` = ? and `friend_id` IN " +
                "(SELECT `friend_id` FROM `facebook`.`friend_list` WHERE `id` = ?)";

        ResultSet resultSet = Database.executeQuery(query, id, friendId);

        try {
            while (resultSet.next()) {

                mutualFriendList.add(new FriendList(id, resultSet.getString("friend_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mutualFriendList;
    }

    public void addComment(Comment comment) {

        query = "INSERT INTO `facebook`.`comments` (`status_id`,`commentator_id`,`comment`)" +
                " VALUES (?, ?, ?)";

        String statusId = comment.getStatusId();
        String userId = comment.getUserId();
        String userComment = comment.getComment();
        Database.insertUpdateDeleteQuery(query, statusId, userId, userComment);
        Database.closeConnection();

    }

    public void likeStatus(Like like) {
        query = "INSERT INTO `facebook`.`status_like` (`status_id`,`user_id`)" +
                " VALUES (?, ?)";

        String id = like.getId();
        String userId = like.getUserId();
        Database.insertUpdateDeleteQuery(query, id, userId);
        Database.closeConnection();

    }

    public void likeComment(Like like) {
        query = "INSERT INTO `facebook`.`comment_like` (`comment_id`,`user_id`)" +
                " VALUES (?, ?)";

        String id = like.getId();
        String userId = like.getUserId();
        Database.insertUpdateDeleteQuery(query, id, userId);
        Database.closeConnection();

    }
}
