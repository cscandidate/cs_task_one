package com.test;

import com.test.reader.EventsLogReader;
import org.junit.Test;

import java.io.File;

public class EventsLogReaderTest {

    @Test
    public void readFile() {
//        given
        File file = new File("src/test/resources/com/test/events.log");

//        when
        new EventsLogReader().read(file);

//        then
    }
}