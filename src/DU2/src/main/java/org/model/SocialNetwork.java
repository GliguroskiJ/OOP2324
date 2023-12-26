package org.model;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<User> users;
    private List<Group> groups;

    public SocialNetwork() {
        this.users = new ArrayList<>();
        this.groups = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void createGroup(String name) {
        Group group = new Group(name);
        groups.add(group);
    }
}
