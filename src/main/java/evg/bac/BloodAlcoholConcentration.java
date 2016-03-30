package evg.bac;

import evg.users.User;

import java.time.ZonedDateTime;

public class BloodAlcoholConcentration implements Comparable<BloodAlcoholConcentration> {

    private final User user;

    private final ZonedDateTime time;

    private final Float bac;

    private final Float latitude;

    private final Float longitude;

    public BloodAlcoholConcentration(User user, ZonedDateTime time, Float bac, Float latitude, Float longitude) {
        this.user = user;
        this.time = time;
        this.bac = bac;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public User getUser() {
        return user;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public Float getBac() {
        return bac;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    @Override
    public int compareTo(BloodAlcoholConcentration o) {
        return time.compareTo(o.getTime());
    }
}
