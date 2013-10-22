package tvguide.test.rest;

import org.jboss.shrinkwrap.api.spec.WebArchive;
import tvguide.deploy.test.MilliTaskDeployment;
import tvguide.rest.BaseEntityService;
import tvguide.rest.BroadcastService;
import tvguide.rest.models.Broadcast;
import tvguide.service.SearchService;

public class RESTDeployment {

    public static WebArchive deployment() {


        return MilliTaskDeployment.deployment()
                .addPackage(Broadcast.class.getPackage())
                .addPackage(BaseEntityService.class.getPackage())
                .addClass(BroadcastService.class)
                .addClass(SearchService.class);
        //.addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml")
//                        .resolve("org.infinispan:infinispan-core").withTransitivity().asFile());
    }

}
