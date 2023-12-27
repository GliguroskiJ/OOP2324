package org.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<User> members;
    private List<Post> posts;

    public Group(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public void addPost(String text, User author, Group group) {
        Post post = new Post(author, text, group);
        posts.add(post);
        author.addPost(text, group);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getName() {
        return name;
    }

    public List<User> getMembers() {
        return members;
    }
}
