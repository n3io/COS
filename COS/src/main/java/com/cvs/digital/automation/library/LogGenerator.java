package com.cvs.digital.automation.library;


import java.util.ArrayList;
import java.util.List;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
/**
 * This class represents a Generator for some logs. It will print out logs in form of "Logging in user <some userame>
 * with id <some id>.
 * Therefor it uses static lists of users and loggers.
 * @author christoph burmeister
 * 
 */
public class LogGenerator {
    /** List of users. */
    private static final List<String> users = new ArrayList<String>();
    /** List of loggers. */
    private static final List<Logger> loggers = new ArrayList<Logger>();
 
    /** Some static initialization of users- and logger-lists. */
    static {
        users.add("anakin");
        users.add("luke");
        users.add("leia");
        users.add("darth");
        users.add("mace");
        users.add("padme");
        users.add("yoda");
        users.add("jarjar");
        users.add("han");
        users.add("chewie");
 
        // the loggers that will appear in the log4j2.xml
        loggers.add(LogManager.getLogger("com.cvs.digital.automation.cos.application"));
        loggers.add(LogManager.getLogger("com.cvs.digital.automation.cos.database"));
    }
 
    /**
     * Entry-point.
     * 
     * @param args
     *            doesn't matter in this case
     */
    public static void main(String[] args) {
        while (true) {
            int logLevel = getRandomNumber(0, 3); // 4 different log-levels
            int loggerId = getRandomNumber(0, loggers.size() - 1);
            Logger logger = loggers.get(loggerId);
            int userId = getRandomNumber(0, users.size() - 1);
            String user = users.get(userId);
 
            log(user, userId, logger, logLevel);
 
            try {
                long sleeptime = getRandomNumber(200, 500);
                Thread.sleep(sleeptime);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
 
        }
    }
 
    /**
     * Method to do the actual logging.
     * 
     * @param user
     *            the username
     * @param userId
     *            the user-id
     * @param logger
     *            the logger to use
     * @param logLevel
     *            the loglevel to use
     */
    private static void log(String user, int userId, Logger logger, int logLevel) {
        switch (logLevel) {
        case 0:
            logger.error("Logging in user {} with id {} ", user, userId);
            break;
        case 1:
            logger.warn("Logging in user {} with id {} ", user, userId);
            break;
        case 2:
            logger.info("Logging in user {} with id {} ", user, userId);
            break;
        case 3:
            logger.debug("Logging in user {} with id {} ", user, userId);
            break;
        }
    }
 
    /**
     * Method to wrap random-mechanism. gets a random number in range of [min...max].
     * 
     * @param min
     *            the minium-value
     * @param max
     *            the maximum-value
     * @return the random int.
     */
    private static int getRandomNumber(int min, int max) {
        int incMax = max + 1;
        int random = min + (int) (Math.random() * (incMax - min) + min);
        return random;
    }
}