package tvguide.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 *
 */
@SuppressWarnings("serial")
public class SearchService implements Serializable {
    @Inject
    EntityManager entityManager;

    private final static Logger logger = LoggerFactory.getLogger(SearchService.class);

    /**
     * Find all the broadcasts from 7am on the given date and until next day before 7am.
     *
     * @param date      Unix time
     * @param channelId Channel Id
     * @return List with broadcasts found
     */
    public List retrieveBroadcasts(Long date, Long nextDay, Long channelId) {
        logger.debug("retrieveBroadcasts with between {} and {}, with channelId {} ", date, nextDay, channelId);
        return entityManager.createQuery("select b from Broadcast b where b.channelId = :givenChannelId " +
                "and b.beginTime > :givenDate and b.beginTime < :nextDay")
                .setParameter("givenChannelId", channelId)
                .setParameter("givenDate", date)
                .setParameter("nextDay", nextDay)
                .getResultList();
    }

    /**
     * Using a native query to perform the JOIN. It was easier than using a Hibernate JOIN.
     *
     * @param seriesId Find broadcasts for this series ID.
     */
    public List retrieveSeasonsAndEpisodes(Long seriesId) {
        logger.debug("retrieveSeasonsAndEpisodes with seriesId {}", seriesId);
        return entityManager.createNativeQuery("select p.season, p.episode, b.beginTime, b.endTime, b.channelId from Program p INNER join Broadcast b ON p.id = b.programId where p.series = :seriesId")
                .setParameter("seriesId", seriesId)
                .getResultList();
    }

    /**
     * @param programId Program ID to find reruns from.
     */
    public List retrieveReruns(Long programId) {
        logger.debug("retrieveReruns with programId {}", programId);
        return entityManager.createQuery("select b from Broadcast b where b.programId = :programId")
                .setParameter("programId", programId).getResultList();
    }


}
