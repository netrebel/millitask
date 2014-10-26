package tvguide.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tvguide.rest.models.Program;
import tvguide.service.SearchService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/programs")
@Stateless
public class ProgramService extends BaseEntityService<Program> {

    private final static Logger logger = LoggerFactory.getLogger(ProgramService.class);

    @Inject
    SearchService searchService;

    public ProgramService() {
        super(Program.class);
    }

    /**
     * Given a specific program, serve reruns of the same programs
     *
     * @param programId
     * @return
     */
    @GET
    @Path("/reruns/{programId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List findReruns(@PathParam("programId") String programId) {
        logger.debug("Find reruns for Program Id: {}", programId);
        return searchService.retrieveReruns(new Long(programId));
    }

}
