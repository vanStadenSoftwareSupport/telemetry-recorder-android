package edu.self.telemetry_recorder;

/**
 * @author grantvanstaden
 * @since 8/12/17.
 */

public class TelemetryDataStoreFactory {

    public static TelemetryDataStore createDataStore() {
        return  new InMemoryTelemetryDataStore();
    }
}
