package evg.data;

import evg.bac.BloodAlcoholConcentration;
import evg.users.User;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryDataSource implements DataSource {

    private final List<User> users = new ArrayList<>();

    private final Map<User, List<BloodAlcoholConcentration>> bacMap = new HashMap<>();

    public InMemoryDataSource() {
        users.add(new User(UUID.randomUUID(), "Olivier"));
        users.add(new User(UUID.randomUUID(), "Clémence"));
        users.add(new User(UUID.randomUUID(), "Élodie"));
        users.add(new User(UUID.randomUUID(), "Hugues"));
        users.add(new User(UUID.randomUUID(), "Antoine"));
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void store(BloodAlcoholConcentration bac) {
        User user = bac.getUser();

        if (bacMap.get(user) == null) {
            bacMap.put(user, new ArrayList<>());
        }

        bacMap.get(user).add(bac);
    }

    @Override
    public List<BloodAlcoholConcentration> getAllBac(User user) {
        if (bacMap.get(user) == null) return new ArrayList<>();
        return bacMap.get(user).stream().sorted().collect(Collectors.toList());
    }
}
