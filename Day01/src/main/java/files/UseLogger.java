package files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UseLogger {
    Logger logger = LogManager.getLogger("AppLogger");

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger("AppLogger");
        logger.info("Hello, World!");
        logger.error("This is an error message");
        logger.debug("This is a debug message");
        logger.warn("This is a warning message");

    }
}
