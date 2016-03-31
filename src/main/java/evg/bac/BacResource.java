package evg.bac;

import evg.AlcoolAmiApplication;
import evg.data.DataSource;
import evg.users.User;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import java.time.ZonedDateTime;
import java.util.*;

public class BacResource extends ServerResource {


    @Put("json")
    public BloodAlcoholConcentration newBloodAlcoholConcentration(BacRequest bacRequest) {
        DataSource dataSource = ((AlcoolAmiApplication)getApplication()).getDataSource();

        try {
            User user = dataSource.getAllUsers()
                    .stream()
                    .filter(u -> u.getUuid().toString().equals(bacRequest.getUuid()))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
            BloodAlcoholConcentration bac = new BloodAlcoholConcentration(
                    user,
                    ZonedDateTime.now(),
                    Float.parseFloat(bacRequest.getBac()),
                    Float.parseFloat(bacRequest.getLatitude()),
                    Float.parseFloat(bacRequest.getLongitude())
            );

            dataSource.store(bac);

            return bac;
        } catch (IllegalArgumentException e) {
            getResponse().setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
            return null;
        }
    }


    @Get
    public Map<String, List<BloodAlcoholConcentration>> getAllBac(String uuid) {
        Map<String, List<BloodAlcoholConcentration>> result = new HashMap<>();

        DataSource dataSource = ((AlcoolAmiApplication)getApplication()).getDataSource();
        dataSource.getAllUsers().forEach(u -> result.put(u.getUuid().toString(), dataSource.getAllBac(u)));

        return result;
    }
}
