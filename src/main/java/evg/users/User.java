package evg.users;

import java.util.UUID;

public class User {

    private final UUID uuid;

    private final String name;

    public User(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() { return uuid; }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) return false;

        if (o == null) return false;

        if (((User) o).getUuid().equals(this.uuid)) return true;
        else return false;
    }

}
