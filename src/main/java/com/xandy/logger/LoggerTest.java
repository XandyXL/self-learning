package com.xandy.logger;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LoggerTest {
     private static final Logger LOGGER = Logger.getLogger(LoggerTest.class);
            


    public static void main(String[] args) {
        LOGGER.setLevel(Level.ERROR);
        LOGGER.error("test1");
    }
}
