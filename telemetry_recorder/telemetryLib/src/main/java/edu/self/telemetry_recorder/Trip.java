package edu.self.telemetry_recorder;

/**
 * Created by grantvanstaden on 2017/12/07.
 */

public class Trip {
    private long databaseId;
    private long startTimeStamp;
    private long endTimeStamp;
    private long distanceInKilometers;
    private long durationInSeconds;
    private String fromSuburb;
    private String toSuburb;

    private Trip(long databaseId, long startTimeStamp, long endTimeStamp, long distanceInKilometers, long durationInSeconds, String fromSuburb, String toSuburb) {
        this.databaseId = databaseId;
        this.startTimeStamp = startTimeStamp;
        this.endTimeStamp = endTimeStamp;
        this.distanceInKilometers = distanceInKilometers;
        this.durationInSeconds = durationInSeconds;
        this.fromSuburb = fromSuburb;
        this.toSuburb = toSuburb;
    }

    public static Trip fromDatabaseEnry(long databaseId, long startTimeStamp, long endTimeStamp, long distanceInKilometers, long durationInSeconds, String fromSuburb, String toSuburb) {
        return new Trip(databaseId, startTimeStamp, endTimeStamp, distanceInKilometers, durationInSeconds, fromSuburb, toSuburb);
    }

    public static Trip recordedNow(long startTimeStamp, long endTimeStamp, long distanceInKilometers, long durationInSeconds, String fromSuburb, String toSuburb) {
        return new Trip(-1, startTimeStamp, endTimeStamp, distanceInKilometers, durationInSeconds, fromSuburb, toSuburb);
    }

    public long getDatabaseId() {
        return databaseId;
    }

    public long getStartTimeStamp() {
        return startTimeStamp;
    }

    public long getEndTimeStamp() {
        return endTimeStamp;
    }

    public long getDistanceInKilometers() {
        return distanceInKilometers;
    }

    public long getDurationInSeconds() {
        return durationInSeconds;
    }

    public String getFromSuburb() {
        return fromSuburb;
    }

    public String getToSuburb() {
        return toSuburb;
    }
}
