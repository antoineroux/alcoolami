package evg;

import org.apache.log4j.Logger;
import org.restlet.representation.InputRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.io.InputStream;


public class IndexResource extends ServerResource {

    private Logger log = Logger.getLogger(IndexResource.class);

    @Get("html")
    public Representation toHtml() {
        InputStream indexStream= this.getClass().getClassLoader().getResourceAsStream("app/index.html");
        return new InputRepresentation(indexStream);
    }
}
