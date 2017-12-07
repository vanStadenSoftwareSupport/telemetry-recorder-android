package edu.self.telemetry_recorder;

import android.content.Context;

import java.util.UUID;

/**
 * Created by grantvanstaden on 2017/12/07.
 */

public class TelemetryRecorder implements  TelemetryRecorderManager {
    private TelemetryDataStore mDataStore;
    private Context mContext;

    public TelemetryRecorder(Context applicationContext) {
        this.mDataStore = TelemetryDataStoreFactory.createDataStore();
        this.mContext = applicationContext;
    }

    TelemetryRecorder(TelemetryDataStore dataStore) {
        this.mDataStore = dataStore;
    }


    public String getRegistration(String userHostAppId) {
        return mDataStore.getRegistration(userHostAppId);
    }

    public String register(String userHostAppId) {
        String registrationId = this.getRegistration(userHostAppId);
        if (registrationId != null &&  !registrationId.isEmpty()) {
            return  registrationId;
        }
        registrationId = UUID.randomUUID().toString();
        mDataStore.saveRegistration(userHostAppId, registrationId);
        return registrationId;
    }

    public boolean isStarted() {
        return mDataStore.isStartedStateRecorded();
    }

    public void start() {
        if (this.isStarted()) {
            return;
        }

        mDataStore.recordStartState(true);
    }

    public void stop() {
        if (!this.isStarted()) {
            return;
        }

        mDataStore.recordStartState(false);
    }
}
