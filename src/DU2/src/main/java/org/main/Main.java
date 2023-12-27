package org.main;
import org.model.*;

public class Main {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        User u1 = new User("Petr Novotný");
        User u2 = new User("Michal Hrůzný");
        User u3 = new User("Lukáš Malý");
        User u4 = new User("Jana Střední");
        User u5 = new User("Lucie Veliká");

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

        u1.addPost("Kočky jsou super", null);
        u2.addPost("Dnes jsem si koupil 8 nových koček", null);
        u3.addPost("Fko", null);
        u4.addPost("Dnes jsem našel malou kočku venku, tak jsem si ji vzal domů", null);
        catsGroup.addPost("Miluju kočky", u2, catsGroup);
        catsGroup.addPost("Kočky jsou úžasný", u1, catsGroup);
        dogsGroup.addPost("Lovískuju svého dogga", u4, dogsGroup);

        u1.getFeed();
        u2.getFeed();
        u3.getFeed();
        u4.getFeed();
        u5.getFeed();
    }
}