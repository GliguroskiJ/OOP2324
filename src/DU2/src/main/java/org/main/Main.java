package org.main;
import org.model.*;

public class Main {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        User u1 = new User("user1");
        User u2 = new User("user2");
        User u3 = new User("user3");
        User u4 = new User("user4");
        User u5 = new User("user5");

        network.registerUser(u1);
        network.registerUser(u2);
        network.registerUser(u3);
        network.registerUser(u4);
        network.registerUser(u5);

        u1.addFriend(u2);
        u1.addFriend(u3);
        u1.addFriend(u4);

        u2.addFriend(u3);
        u2.addFriend(u4);

        u5.addFriend(u3);

        Group dogsGroup = new Group("Pejskaři");
        dogsGroup.addMember(u3);
        dogsGroup.addMember(u4);
        network.createGroup("Pejskaři");

        Group catsGroup = new Group("Kočkaři");
        catsGroup.addMember(u1);
        catsGroup.addMember(u2);
        network.createGroup("Kočkaři");

        u1.addPost("Kočky jsou super");
        u1.addPost("Kočky jsou super2");
        u1.addPost("Kočky jsou super3");
        u2.addPost("Dnes jsem si koupil 8 nových koček");
        u3.addPost("Fko");
        catsGroup.addPost("Miluju kočky", u2);

        u1.getFeed();
    }
}