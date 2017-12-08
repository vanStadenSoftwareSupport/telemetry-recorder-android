package edu.self.telemetry_recorder;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

/**
 * @author grantvanstaden
 * @since 8/12/17.
 */

public class InMemoryTelemetryDataStoreTester {
    @Test
    public void canSaveRegistration() {
        String appId = "appId";
        String registration = "USER001";
        TelemetryDataStore dataStore = new InMemoryTelemetryDataStore();
        dataStore.saveRegistration(appId, registration);
        String actual = dataStore.getRegistration(appId);
        assertEquals(registration, actual);
    }

    @Test
    public void returnsNullIfUserNotRegistered() {
        TelemetryDataStore dataStore = new InMemoryTelemetryDataStore();
        String actual = dataStore.getRegistration("BOGUS");
        assertNull(actual);
    }

    @Test
    public void canGetStartState() {
        TelemetryDataStore dataStore = new InMemoryTelemetryDataStore();
        boolean actual = dataStore.isStartedStateRecorded();
        assertFalse(actual);
    }

    @Test
    public void canSaveStartState() {
        TelemetryDataStore dataStore = new InMemoryTelemetryDataStore();
        dataStore.recordStartState(true);
        boolean actual = dataStore.isStartedStateRecorded();
        assertTrue(actual);
    }
}
