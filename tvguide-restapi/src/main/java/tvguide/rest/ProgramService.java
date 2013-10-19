package tvguide.rest;

import tvguide.rest.models.Program;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/programs")
@Stateless
public class ProgramService extends BaseEntityService<Program> {

    public ProgramService() {
        super(Program.class);
    }

    /**
     * Given a specific program, serve reruns of the same programs
     *
     * @param program
     * @return
     */
    List findReruns(Program program) {
        List<Program> reruns = new ArrayList<Program>();
        reruns.add(new Program());
        return reruns;
    }

}
