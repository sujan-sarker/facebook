import controlar.UserControlar;
import domain.FriendList;

import java.util.List;


/**
 * Created with IntelliJ IDEA.                                                      d
 * domain.User: sujan.sarkar
 * Date: 4/28/14
 * Time: 10:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class faceBook {


    public static void main(String args[]) {
       // UserControlar userControlar = new UserControlar();
        //userControlar.addUser();
        //userControlar.addStatus();
        // userControlar.addFriend();
        //List<FriendList> mutualFriendList = userControlar.mutualFriendList("1","2");
        //printMutualFriend(mutualFriendList);
        //userControlar.addComment();
        //userControlar.likeStatus();
       // userControlar.likeComment();


        /*Object myObj = new String[]{"one", "two", "three"};
                     for (String s : (String[])myObj) System.out.print(s + ".");
*/



    }



    public static void printMutualFriend(List<FriendList> friendList) {

        for (FriendList list : friendList) {
            System.out.println(list.getFriendId());
        }

    }
}


/*
class A {
    int j = 10;
    A(int i)
    {
        System.out.println(i);
    }
    void c()
    {
        System.out.println("Hello in A");
    }
}

class B extends A {

    B(int i) {
        super(i);
        super.c();

    }

    void c()
    {
        System.out.println("Hello in B");
    }
}
*/

