package edu.self.telemetry_recorder;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
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

    @Test
    public void canSaveAndSelectTrips() {
        TelemetryDataStore dataStore = new InMemoryTelemetryDataStore();
        for (int i = 0; i < 10; i++) {
            dataStore.saveTrip(Trip.fromDatabaseEnry(i, (i + 1) * 60000 + (1512702013),  i * 600000 + 1512702013, i + 1, 60, "Suburb A", "Suburb B"));
        }

        List<Trip> trips = dataStore.getTrips();
        assertNotNull(trips);
        assertEquals(10, trips.size());
    }
}
