package controlar;

import dao.UserDao;
import dao.UserDaoImp;
import domain.*;
import util.ProFileManager;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * domain.User: sujan.sarkar
 * Date: 4/28/14
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserControlar {

    private UserDao userDao;
    private Properties prop;

    public UserControlar() {
        userDao = new UserDaoImp();
    }

    public void addUser() {
        try {
            prop = ProFileManager.loadProperties("propfile/user.properties");
            userDao.addUser(new User(prop.getProperty("id"), prop.getProperty("firstName"), prop.getProperty("lastName"), prop.getProperty("dob"), prop.getProperty("email"), prop.getProperty("password")));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void addStatus() {
        try {
            prop = ProFileManager.loadProperties("propfile/status.properties");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        userDao.addStatus(new Status(prop.getProperty("userId"), prop.getProperty("status")));

    }

    public void addFriend() {
        try {
            prop = ProFileManager.loadProperties("propfile/friend_list.properties");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        userDao.addFriend(new FriendList(prop.getProperty("id"), prop.getProperty("friendId")));

    }

    public List<FriendList> mutualFriendList(String id, String friendId) {

        return userDao.getMutualFriendList(id,friendId);

    }

    public void addComment() {
        try {
            prop = ProFileManager.loadProperties("propfile/comment.properties");
            userDao.addComment(new Comment(prop.getProperty("statusId"), prop.getProperty("userId"), prop.getProperty("comment")));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void likeStatus() {
        try {
            prop = ProFileManager.loadProperties("propfile/like.properties");
            userDao.likeStatus(new Like(prop.getProperty("id"), prop.getProperty("userId")));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void likeComment() {
        try {
            prop = ProFileManager.loadProperties("propfile/like.properties");
            userDao.likeComment(new Like(prop.getProperty("id"), prop.getProperty("userId")));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


}
