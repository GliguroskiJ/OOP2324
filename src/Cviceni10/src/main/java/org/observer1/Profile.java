package org.observer1;

import java.util.*;

public class Profile implements PostObservable, PostObserver{

    private String name;
    private List<String> posts = new ArrayList<>();
    private List<String> feed = new ArrayList<>();

    private Set<Profile> subscribers = new HashSet<>();

    public Profile(String name){
        this.name = name;
    }

    public void addPost(String post){
        posts.add(post);
        subscribers.forEach(profile -> profile.notifyPostAdded(post));
    }

    @Override
    public void notifyPostAdded(String post) {
        feed.add(post);
    }

    @Override
    public void subscribe(Profile profile) {
        subscribers.add(profile);
    }

    @Override
    public void unsubscribe(Profile profile) {
        subscribers.remove(profile);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(name, profile.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public List<String> getFeed() {
        return feed;
    }
}
