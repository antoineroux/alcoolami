package evg.users;

import evg.AlcoolAmiApplication;
import org.restlet.Context;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.List;

public class UsersResource extends ServerResource {

    @Get
    public List<User> getAllUsers() {
       return ((AlcoolAmiApplication)getApplication()).getDataSource().getAllUsers();
    }


}
