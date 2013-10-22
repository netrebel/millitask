package tvguide.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tvguide.rest.models.Broadcast;
import tvguide.service.SearchService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple CDI service which is able to say hello to someone
 *
 * @author Miguel Reyes
 */
@Path("/broadcasts")
@Stateless
public class BroadcastService extends BaseEntityService<Broadcast> {

    private final static Logger logger = LoggerFactory.getLogger(BroadcastService.class);

    @Inject
    SearchService searchService;

    public BroadcastService() {
        super(Broadcast.class);
    }

    /**
     * Given a specific day and a specific channel,
     * serve the broadcasts that are within 07:00 AM the same day and 07:00 AM the following day
     *
     * @param date
     * @param channelId
     * @return
     */
    @GET
    @Path("/find/{date}/{channelId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findTodaysBroadcasts(@PathParam("date") String date, @PathParam("channelId") Long channelId) {
        logger.debug("Date {} and channelId {}", date, channelId);
        searchService.retrieveBroadcasts(unixTimeFromDate(date), channelId);

        return "{\"result\":\"" + "Date: " + date + " and ChannelId: " + channelId + "\"}";
    }


    private Long unixTimeFromDate(String receivedDate) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(receivedDate);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null; //invalid date
    }

}
