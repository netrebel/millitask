package tvguide.deploy.test;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import tvguide.rest.util.Resources;

public class MilliTaskDeployment {

    public static WebArchive deployment() {
        return ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addPackage(Resources.class.getPackage())
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsResource("import.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                        // Deploy our test datasource
                .addAsWebInfResource("millitask-ds.xml");
    }
}
