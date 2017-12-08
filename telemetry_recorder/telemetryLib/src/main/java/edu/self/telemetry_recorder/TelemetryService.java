package edu.self.telemetry_recorder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * @author grantvanstaden
 * @since 8/12/17.
 */

public class TelemetryService extends Service {
    static final String ACTION_START = "START_TELEMETRY",
                        ACTION_STOP = "STOP_TELEMETRY";
    private boolean mIsStarted;
    private TelemetryDataStore mDataStore;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && intent.getAction() != null && intent.getAction().equals(ACTION_START)) {
            if (startMonitoringTelemetry()) {
                return START_REDELIVER_INTENT;
            }
        } else if (intent != null && intent.getAction() != null && intent.getAction().equals(ACTION_STOP)) {
             stopMonitoringTelemetry();
        }

        return START_NOT_STICKY;
    }

    private void stopMonitoringTelemetry() {
        this.stopSelf();
    }

    private boolean startMonitoringTelemetry() {
        if (mIsStarted) {
            return  false;
        }
        mIsStarted = true;
        mDataStore = TelemetryDataStoreFactory.createDataStore();
        for (int i = 0; i < 10; i++) {
            mDataStore.saveTrip(Trip.fromDatabaseEnry(i, (i + 1) * 60000 + (1512702013),  i * 600000 + 1512702013, i + 1, 60, "Suburb A", "Suburb B"));
        }
        
        return true;
    }
}
