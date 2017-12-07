package edu.self.telemetry_recorder;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * @author grantvanstaden
 * @since 8/12/17.
 */

public class InMemoryTelemetryDataStore implements TelemetryDataStore {
    private Dictionary<String, String> registrations;
    private boolean isStarted;

    public InMemoryTelemetryDataStore() {
        this.registrations = new Hashtable<>();
    }

    @Override
    public String getRegistration(String userHostAppId) {
        return registrations.get(userHostAppId);
    }

    @Override
    public boolean isStartedStateRecorded() {
        return isStarted;
    }

    @Override
    public void recordStartState(boolean isStarted) {
        this.isStarted = isStarted;
    }

    @Override
    public String saveRegistration(String userHostAppId, String telemetryId) {
        registrations.put(userHostAppId, telemetryId);
        return  telemetryId;
    }
}
