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
        this.members.add(user);
    }

    public boolean isMember(User user){
        if (members.contains(user)) return true;
        else return false;
    }

    public void addPost(String text, User author, Group group) throws Exception {
        if (isMember(author)){
            Post post = new Post(author, text, group);
            for (User member : members) {
                member.getFeed().addPost(post);
            }
        }else throw new Exception("Uživatel "+author.getUsername()+" není členem skupiny "+group.getName());
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
