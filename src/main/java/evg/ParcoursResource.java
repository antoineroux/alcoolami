package evg;

import org.apache.log4j.Logger;
import org.restlet.representation.InputRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.io.InputStream;


public class ParcoursResource extends ServerResource {

    private Logger log = Logger.getLogger(ParcoursResource.class);

    @Get("html")
    public Representation toHtml() {
        InputStream indexStream= this.getClass().getClassLoader().getResourceAsStream("app/parcours.html");
        return new InputRepresentation(indexStream);
    }
}
