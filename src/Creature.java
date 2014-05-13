/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 4/29/14
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Creature {

    public static void main(String args[])  {
        SomeClass o = new SomeClass();
        synchronized (o) {
          //  o.wait();
            o.notify();
        }
    }
}

class SomeClass {

}