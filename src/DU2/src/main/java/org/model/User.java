package org.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Objects;

public class User {
    private String username;
    private List<User> friends;
    private List<Group> groups;
    private List<Post> posts;
    private Feed feed;

    public User(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.feed = new Feed();
    }

    public void addFriend(User user) {
        friends.add(user);
        user.friends.add(this);
    }

    public void addPost(String text) {
        Post post = new Post(this, text);
        posts.add(post);
        addToFeed(post);
    }

    public void addGroupPost(String text, Group group) {
        Post post = new Post(this, text, group);
        posts.add(post);
        addToFeed(post);
    }

    public void addToFeed(Post post) {
        feed.addPost(post);
        //updateFeed();
    }

    public String getUsername() {
        return username;
    }

    public void updateFeed() {
        feed = new Feed();
        /*for (User friend : friends) {
            feed.getPosts().addAll(friend.posts);
        }*/
        for (Group group : groups) {
            for (int i = 0; i < group.getMembers().size(); i++) {
                if (group.getMembers().get(i).toString() == username) {
                    feed.getPosts().addAll(group.getPosts());
                }
            }
        }
        feed.getPosts().addAll(posts);
        Collections.shuffle(feed.getPosts());
    }

    public void getFeed() {
        updateFeed();
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
}
