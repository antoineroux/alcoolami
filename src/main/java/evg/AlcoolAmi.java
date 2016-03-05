package evg;

import org.apache.log4j.Logger;
import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 * Main class that configures the web server and starts it.
 */
public class AlcoolAmi {

    private static final int serverPort = 8000;

    private static final Component component = new Component();
    private static final Logger  log = Logger.getLogger(AlcoolAmi.class);

    public static void main(String [] args) {
        component.getServers().add(Protocol.HTTP, serverPort);
        component.getClients().add(Protocol.CLAP);
        component.getDefaultHost().attachDefault(new AlcoolAmiApplication());

        try {
            component.start();
            log.info("Application started");
        } catch (Exception e) {
            log.error("Application startup on port " + serverPort + " failed", e);
        }
    }

}
