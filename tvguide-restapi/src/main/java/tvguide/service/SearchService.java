package tvguide.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 *
 */
@SuppressWarnings("serial")
public class SearchService implements Serializable {
    @Inject
    EntityManager entityManager;

    private final static Logger logger = LoggerFactory.getLogger(SearchService.class);

    public void retrieveBroadcasts(Long date, Long channelId) {
        logger.debug("retrieveBroadcasts with date {} and channelId {} ", date, channelId);
        //TODO implement
    }

    public void retrieveSeasonsAndEpisodes(String seriesId) {
        logger.debug("retrieveSeasonsAndEpisodes with seriesId {}", seriesId);
        //TODO implement
    }

    public void retrieveReruns(String programId) {
        logger.debug("retrieveReruns with programId {}", programId);
        //TODO implement
    }
}
