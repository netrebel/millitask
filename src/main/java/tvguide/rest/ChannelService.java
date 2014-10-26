package tvguide.rest;

import tvguide.rest.models.Channel;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * <p>
 * A JAX-RS endpoint for handling {@link Channel}s. Inherits the actual
 * methods from {@link BaseEntityService}.
 * </p>
 */
@Path("/channels")
/**
 * <p>
 *     This is a stateless service, we declare it as an EJB for transaction demarcation
 * </p>
 */
@Stateless
public class ChannelService extends BaseEntityService<Channel> {

    public ChannelService() {
        super(Channel.class);
    }
}
