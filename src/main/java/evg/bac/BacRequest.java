package evg.bac;

public class BacRequest {

    private String uuid;

    private String bac;

    private String latitude;

    private String longitude;

    public BacRequest() {
        super();
    }

    public BacRequest(String uuid, String bac, String latitude, String longitude) {
        this.uuid = uuid;
        this.bac = bac;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBac() {
        return bac;
    }

    public void setBac(String bac) {
        this.bac = bac;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
