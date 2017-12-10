package edu.self.telemetry_recorder;

/**
 * Created by grantvanstaden on 2017/12/07.
 */

 interface TelemetryRecorderManager {
    String getRegistration(String userHostAppId) ;
    String register(String userHostAppId) ;
    boolean isStarted() ;
    void start() ;
    void stop() ;
}
