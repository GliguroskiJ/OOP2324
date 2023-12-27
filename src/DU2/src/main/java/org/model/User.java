package org.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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

    public void addPost(String text, Group group) {
        Post post = new Post(this, text, group);
        posts.add(post);
        addToFeed(post);
    }

    public void addToFeed(Post post) {
        feed.addPost(post);
        updateFeed();
    }

    public String getUsername() {
        return username;
    }

    public void updateFeed() {
        feed = new Feed();
        for (User friend : friends) {
            feed.getPosts().addAll(friend.posts);
        }
        for (Group group : groups) {
            if (group.getMembers().toString().contains(this.username)) {
                feed.getPosts().addAll(group.getPosts());
            }
        }
        feed.getPosts().addAll(getPosts());
        Collections.shuffle(feed.getPosts());
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void getFeed() {
        updateFeed();
        System.out.println("\nFeed uživatele: "+this.username);
        for (int i = 0; i < feed.getPosts().size(); i++){
            if (feed.getPosts().get(i).getGroup() == null) {
                System.out.println("Uživatel " + feed.getPosts().get(i).getAuthor().getUsername() + " přidal příspěvek: " + feed.getPosts().get(i).getText());
            }
            else if (feed.getPosts().get(i).getGroup().getName() != null){
                System.out.println("Uživatel " + feed.getPosts().get(i).getAuthor().getUsername() + " přidal příspěvek do skupiny "+feed.getPosts().get(i).getGroup().getName()+": "+feed.getPosts().get(i).getText());
            }
        }
    }
}
