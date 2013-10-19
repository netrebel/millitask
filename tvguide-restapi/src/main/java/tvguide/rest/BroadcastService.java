package tvguide.rest;

import tvguide.rest.models.Broadcast;
import tvguide.rest.models.Channel;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple CDI service which is able to say hello to someone
 *
 * @author Miguel Reyes
 */
@Path("/broadcasts")
@Stateless
public class BroadcastService extends BaseEntityService<Broadcast> {

    public BroadcastService() {
        super(Broadcast.class);
    }

    /**
     * Given a specific day and a specific channel,
     * serve the broadcasts that are within 07:00 AM the same day and 07:00 AM the following day
     *
     * @param date
     * @param channel
     * @return
     */
    List findBroadcasts(String date, Channel channel) {
        //TODO Implement findBroadcasts
        List<Broadcast> foundBroadcasts = new ArrayList<Broadcast>();
        return foundBroadcasts;
    }

    /**
     * Given a specific series, serve a list of seasons and episodes,
     * with corresponding broadcasts for each episode.
     *
     * @param series
     * @return
     */
    List findSeasonsAndEpisodes(String series) {
        //TODO Implement
        return null;
    }

}
