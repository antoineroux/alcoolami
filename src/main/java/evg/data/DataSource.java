package evg.data;

import evg.bac.BloodAlcoholConcentration;
import evg.users.User;

import java.util.List;

public interface DataSource {

    public List<User> getAllUsers();

    public void store(BloodAlcoholConcentration bac);

    public List<BloodAlcoholConcentration> getAllBac(User user);

}
