package org.observer1;

public interface PostObservable {

    void subscribe(Profile profile);

    void unsubscribe(Profile profile);
}
