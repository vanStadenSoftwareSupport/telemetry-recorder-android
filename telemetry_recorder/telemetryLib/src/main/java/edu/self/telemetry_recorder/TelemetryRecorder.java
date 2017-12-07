package edu.self.telemetry_recorder;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by grantvanstaden on 2017/12/07.
 */

public interface TelemetryRecorder {
    public String getRegistration(String userHostAppId) ;
    public String register(String userHostAppId) ;
    public boolean isStarted() ;
    public void start() ;
    public void stop() ;
}
