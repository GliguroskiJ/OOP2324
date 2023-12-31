package org.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Objects;

public class User implements Observer, Observable{
    private String username;
    private List<User> friends;
    private Feed feed;

    public User(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
        this.feed = new Feed();
    }

    public void addPost(String text) {
        Post post = new Post(this, text);
        feed.addPost(post);
        notifyAboutPost(post);
    }
    public void addPostTest (Post post){
        feed.addPost(post);
        notifyAboutPost(post);
    }

    public String getUsername() {
        return username;
    }

    public Feed getFeed() {
        return feed;
    }

    public void showFeed() {
        System.out.println("\nFeed uživatele: " + this.username);
        for (int i = 0; i < feed.getPosts().size(); i++) {
            if (feed.getPosts().get(i).getGroup() == null) {
                if (Objects.equals(feed.getPosts().get(i).getAuthor().getUsername(), username)) {
                    System.out.println("Přidal/a jste příspěvek: " + feed.getPosts().get(i).getText());
                } else {
                    System.out.println("Uživatel/ka " + feed.getPosts().get(i).getAuthor().getUsername() + " přidal/a příspěvek: " + feed.getPosts().get(i).getText());
                }
            } else if (feed.getPosts().get(i).getGroup().getName() != null) {
                if (Objects.equals(feed.getPosts().get(i).getAuthor().getUsername(), username)) {
                    System.out.println("Přidal/a jste příspěvek do skupiny " + feed.getPosts().get(i).getGroup().getName() + ": " + feed.getPosts().get(i).getText());
                } else {
                    System.out.println("Uživatel/ka " + feed.getPosts().get(i).getAuthor().getUsername() + " přidal/a příspěvek do skupiny " + feed.getPosts().get(i).getGroup().getName() + ": " + feed.getPosts().get(i).getText());
                }
            }
        }
    }

    @Override
    public void notifyAboutPost(Post post) {
        for (User friend : friends) {
            friend.feed.addPost(post);
        }
    }

    @Override
    public void addPerson(User user) {
        friends.add(user);
        user.friends.add(this);
    }
}
