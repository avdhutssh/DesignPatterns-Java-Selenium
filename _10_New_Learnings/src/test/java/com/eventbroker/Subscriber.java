package com.eventbroker;

public interface Subscriber<T> {
    void onEvent(Event<T> event);
}
