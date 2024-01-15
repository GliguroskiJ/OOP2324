package org.proxy2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GateReal implements Gate{
    private static final Logger logger = LogManager.getLogger(GateReal.class);
    @Override
    public Person open(Person person) {
        logger.info("Opening gate for " + person.getName());
        //Do something
        logger.info("Gate opened for " + person.getName());
        return person;
    }
}
