package edu.self.telemetry_recorder;

import android.content.Context;
import android.content.Intent;

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

        Intent intent = new Intent(mContext, TelemetryService.class);
        intent.setAction(TelemetryService.ACTION_START);
        mContext.startService(intent);
        mDataStore.recordStartState(true);
    }

    public void stop() {
        if (!this.isStarted()) {
            return;
        }

        Intent intent = new Intent(mContext, TelemetryService.class);
        intent.setAction(TelemetryService.ACTION_STOP);
        mContext.startService(intent);
        mDataStore.recordStartState(false);
    }
}
