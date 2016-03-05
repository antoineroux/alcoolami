package evg;

import org.apache.log4j.Logger;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;


public class AlcoolAmiApplication extends Application {

    private static final Logger log = Logger.getLogger(AlcoolAmiApplication.class);

    @Override
    public Restlet createInboundRoot() {
        Directory directory = new Directory(getContext(), "clap://class/app");

        Router router = new Router(getContext());
        router.attach("/", IndexResource.class);

        router.attachDefault(directory);

        return router;
    }
}
