package tvguide.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tvguide.rest.models.Series;
import tvguide.service.SearchService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/series")
@Stateless
public class SeriesService extends BaseEntityService<Series> {

    private final static Logger logger = LoggerFactory.getLogger(SeriesService.class);

    @Inject
    SearchService searchService;

    public SeriesService() {
        super(Series.class);
    }

    /**
     * Given a specific series, serve a list of seasons and episodes,
     * with corresponding broadcasts for each episode.
     *
     * @param seriesId
     * @return JSON List with program.season, program.episode, program.beginTime, broadcast.endTime, broadcast.channelId
     */
    @GET
    @Path("/find/{seriesId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List findSeasonsAndEpisodes(@PathParam("seriesId") String seriesId) {
        logger.debug("Find seasons and episodes for series {}", seriesId);
        return searchService.retrieveSeasonsAndEpisodes(new Long(seriesId));
    }
}
