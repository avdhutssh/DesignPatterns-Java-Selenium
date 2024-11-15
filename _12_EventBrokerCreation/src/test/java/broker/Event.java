package broker;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class Event {
    private final String type;
    private final Object body;
    private final long timeout;
    private final int priority;
    private final String sender;
    private final Map<String, Object> headers;
    private final Date time;

    private Event() {
        this.type = null;
        this.body = null;
        this.timeout = 0;
        this.priority = 0;
        this.sender = null;
        this.headers = new HashMap<>();
        this.time = new Date();
    }

    // Getters
    public String getType() {
        return type;
    }

    public Object getBody() {
        return body;
    }

    public long getTimeout() {
        return timeout;
    }

    public int getPriority() {
        return priority;
    }

    public String getSender() {
        return sender;
    }

    public Map<String, Object> getHeaders() {
        return Collections.unmodifiableMap(headers);
    }

    public Date getTime() {
        return (Date) time.clone();
    }
}
