package edu.self.telemetry_recorder;

/**
 * Created by grantvanstaden on 2017/12/07.
 */

public interface TelemetryRecorderManager {
    public String getRegistration(String userHostAppId) ;
    public String register(String userHostAppId) ;
    public boolean isStarted() ;
    public void start() ;
    public void stop() ;
}
