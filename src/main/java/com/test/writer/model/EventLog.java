package com.test.writer.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public class EventLog {

    final String id;
    final String type;
    final String host;

    long duration;

    public void setDuration(long duration) {
        this.duration = duration;

        if (duration > 4) {
            log.debug("Event with id {} took {} ms", this.getId(), this.getDuration());
            this.alert = true;
        }
    }

    boolean alert;
}
