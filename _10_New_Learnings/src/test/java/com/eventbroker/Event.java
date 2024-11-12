package com.eventbroker;

import java.time.LocalDateTime;
import java.util.Map;

public final class Event<T> {
    private final LocalDateTime timestamp;
    private final Long timeout;
    private final Integer priority;
    private final String sender;
    private final T payload;
    private final Map<String, String> customHeaders;

    public Event(LocalDateTime timestamp, Long timeout, Integer priority, String sender, T payload, Map<String, String> customHeaders) {
        this.timestamp = timestamp;
        this.timeout = timeout;
        this.priority = priority;
        this.sender = sender;
        this.payload = payload;
        this.customHeaders = customHeaders;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Long getTimeout() {
        return timeout;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getSender() {
        return sender;
    }

    public T getPayload() {
        return payload;
    }

    public Map<String, String> getCustomHeaders() {
        return customHeaders;
    }
}
