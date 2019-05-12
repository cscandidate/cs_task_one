package com.test.processor;

import com.test.reader.json.GsonJsonReader;
import com.test.reader.json.JsonReader;
import com.test.reader.model.EventItem;
import com.test.reader.model.State;
import com.test.writer.model.EventLog;
import com.test.writer.model.service.EventLogService;
import com.test.writer.model.service.EventLogWriter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class EventItemProcessor {

    // TODO: inject implementation using DI framework
    private JsonReader jsonReader = new GsonJsonReader();
    private EventLogWriter eventLogWriter = new EventLogService();

    private Map<String, EventItem> map = new HashMap<>();

    public void process(String line) {
        EventItem eventItem = jsonReader.fromJson(line, EventItem.class);
        log.debug(eventItem.toString());

        EventLog eventLog = new EventLog(eventItem.getId(), eventItem.getType(), eventItem.getHost());
        EventItem eventItem1 = map.get(eventItem.getId());
        if (eventItem1 != null) {
            long time = State.STARTED == eventItem1.getState() ?
                    eventItem.getTimestamp() - eventItem1.getTimestamp() :
                    eventItem1.getTimestamp() - eventItem.getTimestamp();
            eventLog.setDuration(time);

            map.remove(eventItem.getId());
        } else {
            map.put(eventItem.getId(), eventItem);
        }

        eventLogWriter.write(eventLog);
    }
}
