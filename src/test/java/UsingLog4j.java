import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


public class UsingLog4j {

    private static Logger LOG = LogManager.getLogger(UsingLog4j.class);

    @Test
    public void testLog4j() {
        LOG.info("Information message");
        LOG.debug("Debug message");
        LOG.error("Error message");
    }
}

