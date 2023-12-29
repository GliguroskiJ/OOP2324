package org.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<User> members;

    public Group(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public void addMember(User user) {
        this.members.add(user);
    }

    public boolean isMember(User user) {
        if (members.contains(user)) return true;
        else return false;
    }

    public void addPost(String text, User author) throws Exception {
        if (isMember(author)) {
            Post post = new Post(author, text, this);
            for (User member : members) {
                member.getFeed().addPost(post);
            }
        } else throw new Exception("Uživatel " + author.getUsername() + " není členem skupiny " + this.getName());
    }

    public String getName() {
        return name;
    }
}
