package utils;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class TopologyLogger {
    private static Logger logger;

    static{
        logger = Logger.getLogger("TupleLogger");
        FileHandler fh;

        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("tuples.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String entry){
        logger.info(entry);
    }
}
