package org.model;

public class Post {
    private User author;
    private String text;
    private Group group;

    public Post(User author, String text, Group group) {
        this.author = author;
        this.text = text;
        this.group = group;
    }

    public Post(User author, String text) {
        this.author = author;
        this.text = text;
        this.group = null;
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Group getGroup() {
        return group;
    }
}
