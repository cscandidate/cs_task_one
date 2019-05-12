package com.test.reader.model;

import lombok.Data;

import java.util.Objects;

@Data
public class EventItem {

    String id;
    State state;
    long timestamp;

    // TODO: maybe it shoud be Enum, but I don't know it right now
    String type;
    String host;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventItem eventItem = (EventItem) o;
        return id.equals(eventItem.id) &&
                state == eventItem.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state);
    }
}
