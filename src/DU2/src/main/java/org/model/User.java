package org.model;

import java.util.ArrayList;
import java.util.List;

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
        user.friends.add(this); // Ensure mutual friendship
    }

    public void addPost(String text) {
        Post post = new Post(this, text);
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
            feed.getPosts().addAll(group.getPosts());
        }
        feed.getPosts().addAll(getPosts());
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void getFeed() {
        updateFeed();
        for (int i = 0; i < feed.getPosts().size(); i++){
            System.out.println("Uživatel "+feed.getPosts().get(i).getAuthor().getUsername()+" přidal příspěvek: "+feed.getPosts().get(i).getText()+"\n");
        }
    }
}
