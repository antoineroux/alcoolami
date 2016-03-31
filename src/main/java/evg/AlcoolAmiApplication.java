package evg;

import evg.bac.BacResource;
import evg.users.UsersResource;
import evg.data.DataSource;
import evg.data.InMemoryDataSource;
import org.apache.log4j.Logger;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;


public class AlcoolAmiApplication extends Application {

    private static final Logger log = Logger.getLogger(AlcoolAmiApplication.class);

    private final DataSource dataSource = new InMemoryDataSource();

    @Override
    public Restlet createInboundRoot() {
        Directory directory = new Directory(getContext(), "clap://class/app");

        Router router = new Router(getContext());
        router.attach("/", IndexResource.class);
        router.attach("/parcours", ParcoursResource.class);
        router.attach("/participants", UsersResource.class);
        router.attach("/bac", BacResource.class);
        router.attachDefault(directory);

        return router;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

}
