package org.model;

public class Post {
    private User author;
    private String text;

    public Post(User author, String text) {
        this.author = author;
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }
}
