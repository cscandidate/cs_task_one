package com.test.writer.repository;

import com.test.writer.model.EventLog;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

@Slf4j
public class EventLogDao {

    public void batchInsert(Collection<EventLog> eventLogs) throws SQLException {
        Properties myProp = new Properties();
        myProp.put("user", "ExampleUser");
        myProp.put("password", "password123");

        //Set streamingBatchInsert to True to enable streaming mode for batch inserts.
        //myProp.put("streamingBatchInsert", "True");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:vertica://VerticaHost:5433/ExampleDB",
                    myProp);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }

        connection.setAutoCommit(false);
        String query = "INSERT INTO event_logs (id, duration, type, host, alert) VALUES(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        for (EventLog eventLog : eventLogs) {
            statement.setString(1, eventLog.getId());
            statement.setLong(2, eventLog.getDuration());
            statement.setString(3, eventLog.getType());
            statement.addBatch();
        }

        statement.executeBatch();
        statement.clearBatch();
        connection.commit();
        connection.close();
    }
}
