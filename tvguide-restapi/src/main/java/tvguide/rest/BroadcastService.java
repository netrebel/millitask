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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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
    public List findTodaysBroadcasts(@PathParam("date") String date, @PathParam("channelId") Long channelId) {
        logger.debug("Date {} and channelId {}", date, channelId);
        return searchService.retrieveBroadcasts(unixTimeFromGivenDate(date), nextDay(date), channelId);
        //return "{\"result\":\"" + "Date: " + date + " and ChannelId: " + channelId + "\"}";
    }


    /**
     * Method to return Unix time
     *
     * @param givenDate Date in format "yyyy-MM-dd".
     * @return Long with date in Unix time.
     */
    private Long unixTimeFromGivenDate(String givenDate) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+2"));

        try {
            String completeDate = givenDate + " 07:00:00";
            Date date = formatter.parse(completeDate);
            //String formattedDate = formatter.format(date);
            return date.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null; //invalid date
    }

    private Long nextDay(String givenDate) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String completeDate = givenDate + " 07:00:00";
        try {
            Date date = formatter.parse(completeDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(calendar.DAY_OF_MONTH, 1);
            return calendar.getTimeInMillis() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

}
