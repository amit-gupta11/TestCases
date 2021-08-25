package testcases.util;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class Logs {

    static Logger logger = Logger.getLogger(Logs.class);
    public static final String LOG_PATH = "C:\\Users\\Public\\MyLogFile\\";

    static {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormatDate = new SimpleDateFormat("dd_MM_yyyy");
        Date date = new Date();
        String formattedDate = dateFormatDate.format(date);
        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
        layout.setConversionPattern(conversionPattern);

        FileAppender fileAppender = new FileAppender();
        fileAppender.setFile(LOG_PATH + "Error_log_" + formattedDate + ".log");
        fileAppender.setLayout(layout);
        fileAppender.activateOptions();

        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.DEBUG);
        rootLogger.addAppender(fileAppender);
    }

    public static void printLogs(String message) {

        logger.error(message);
    }
}
