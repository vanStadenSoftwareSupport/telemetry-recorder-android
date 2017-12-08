package edu.self.telemetry_recorder;

import java.util.List;

/**
 * Created by grantvanstaden on 2017/12/07.
 */

interface TelemetryDataStore {
    String getRegistration(String userHostAppId);
    boolean isStartedStateRecorded();
    void recordStartState(boolean isStarted);
    String saveRegistration(String userHostAppId, String telemetryId);
    void saveTrip(Trip newTrip);
    List<Trip> getTrips();
}
