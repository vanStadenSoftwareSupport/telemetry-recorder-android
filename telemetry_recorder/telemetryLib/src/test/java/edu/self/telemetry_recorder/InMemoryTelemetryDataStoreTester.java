package edu.self.telemetry_recorder;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

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
}
