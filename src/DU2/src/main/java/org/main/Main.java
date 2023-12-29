package org.main;

import org.model.*;

public class Main {
    public static void main(String[] args) throws Exception {
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
        u5.addFriend(u4);

        Group dogsGroup = new Group("Pejskaři");
        dogsGroup.addMember(u3);
        dogsGroup.addMember(u4);
        network.createGroup("Pejskaři");

        Group catsGroup = new Group("Kočkaři");
        catsGroup.addMember(u1);
        catsGroup.addMember(u2);
        network.createGroup("Kočkaři");

        /*for (int i = 0; i < catsGroup.getMembers().size(); i++){
            System.out.println(catsGroup.getMembers().get(i).getUsername());
        }
        for (int i = 0; i < dogsGroup.getMembers().size(); i++){
            System.out.println(dogsGroup.getMembers().get(i).getUsername());
        }*/

        u1.addPost("Kočky jsou super");
        u2.addPost("Dnes jsem si koupil 8 nových koček");
        u3.addPost("Fko");
        u4.addPost("Dnes jsem našla malou kočku venku, tak jsem si ji vzala domů");
        catsGroup.addPost("Miluju kočky", u2);
        catsGroup.addPost("Kočky jsou úžasný", u1);
        dogsGroup.addPost("Lovískuju svého dogga", u4);
        //dogsGroup.addPost("Lovískuju svého dogga", u1);

        u1.showFeed();
        u2.showFeed();
        u3.showFeed();
        u4.showFeed();
        u5.showFeed();
    }
}