package evg.bac;

import evg.AlcoolAmiApplication;
import evg.data.DataSource;
import evg.users.User;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BacResource extends ServerResource {


    @Put
    public BloodAlcoholConcentration newBloodAlcoholConcentration(BloodAlcoholConcentration bac) {
        ((AlcoolAmiApplication)getApplication()).getDataSource().store(bac);

        return bac;
    }


    @Get
    List<BloodAlcoholConcentration> getAllBac(String uuid) {
        DataSource dataSource = ((AlcoolAmiApplication)getApplication()).getDataSource();
        return dataSource.getAllUsers()
                .stream()
                .filter(u -> u.getUuid().toString().equals(uuid))
                .findFirst()
                .map(u -> dataSource.getAllBac(u))
                .orElse(new ArrayList<>());


    }
}
