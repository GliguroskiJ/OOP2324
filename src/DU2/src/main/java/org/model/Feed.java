package org.model;

import java.util.ArrayList;
import java.util.List;

public class Feed {
    private List<Post> posts;

    public Feed() {
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public List<Post> getPosts() {
        return posts;
    }
}

