package edu.self.telemetry_recorder;

/**
 * @author grantvanstaden
 * @since 8/12/17.
 */

class TelemetryDataStoreFactory {
    private static TelemetryDataStore sDataStore;

    static TelemetryDataStore createDataStore() {
        if (sDataStore == null) {
            sDataStore = new InMemoryTelemetryDataStore();
        }
        return  sDataStore;
    }
}
