package com.eventbroker;

public interface Publisher {
    <T> void publish(Event<T> event);
}
