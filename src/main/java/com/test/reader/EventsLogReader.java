package com.test.reader;

import com.test.reader.exception.LogFileNotFoundException;
import com.test.reader.exception.LogIOException;
import com.test.processor.EventItemProcessor;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class EventsLogReader {

    private EventItemProcessor eventItemProcessor = new EventItemProcessor();

    public void read(File file) {
        try (BufferedReader b = new BufferedReader(new FileReader(file))) {
            String readLine;
            while ((readLine = b.readLine()) != null) {
                eventItemProcessor.process(readLine);
            }
        } catch (FileNotFoundException e) {
            throw new LogFileNotFoundException(e);
        } catch (IOException e) {
            throw new LogIOException(e);
        }
    }
}
