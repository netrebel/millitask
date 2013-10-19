package tvguide.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tvguide.service.SearchService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 */
@Path("/series")
@Stateless
public class SeriesService {

    private final static Logger logger = LoggerFactory.getLogger(SeriesService.class);

    @Inject
    SearchService searchService;

    /**
     * Given a specific series, serve a list of seasons and episodes,
     * with corresponding broadcasts for each episode.
     *
     * @param seriesId
     * @return
     */
    @GET
    @Path("/find/{seriesId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findSeasonsAndEpisodes(@PathParam("seriesId") String seriesId) {
        //TODO Implement
        logger.debug("Find seasons and episodes for series {}", seriesId);
        searchService.retrieveSeasonsAndEpisodes(seriesId);
        return "{\"result\":\"" + "seriesId: " + seriesId + "\"}";
    }
}
