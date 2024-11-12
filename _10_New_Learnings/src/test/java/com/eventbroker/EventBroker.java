package com.eventbroker;

import java.util.concurrent.*;
import java.util.*;

public class EventBroker {
    private final Map<Class<?>, List<Subscriber<?>>> subscriberMap = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public <T> void registerSubscriber(Class<T> eventType, Subscriber<T> subscriber) {
        subscriberMap.computeIfAbsent(eventType, k -> new ArrayList<>()).add(subscriber);
    }

    public <T> void publishEvent(Event<T> event) {
        Class<?> eventType = event.getPayload().getClass();
        List<Subscriber<?>> subscribers = subscriberMap.getOrDefault(eventType, Collections.emptyList());

        for (Subscriber<?> sub : subscribers) {
            @SuppressWarnings("unchecked")
            Subscriber<T> typedSubscriber = (Subscriber<T>) sub;
            executorService.submit(() -> typedSubscriber.onEvent(event));
        }
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
