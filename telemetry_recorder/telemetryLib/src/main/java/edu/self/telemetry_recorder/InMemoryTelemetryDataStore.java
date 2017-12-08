package edu.self.telemetry_recorder;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * @author grantvanstaden
 * @since 8/12/17.
 */

class InMemoryTelemetryDataStore implements TelemetryDataStore {
    private Dictionary<String, String> registrations;
    private List<Trip> trips;
    private boolean isStarted;

    InMemoryTelemetryDataStore() {
        this.registrations = new Hashtable<>();
        this.trips = new ArrayList<>();
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

    @Override
    public void saveTrip(Trip newTrip) {
        trips.add(newTrip);
    }

    @Override
    public List<Trip> getTrips() {
        return trips;
    }
}
