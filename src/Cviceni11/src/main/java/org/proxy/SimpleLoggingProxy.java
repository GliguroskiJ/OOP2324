package org.proxy;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SimpleLoggingProxy implements Service{
    private Service service;
    private static final Logger logger = LogManager.getLogger(SimpleLoggingProxy.class);

    public SimpleLoggingProxy(Service service) {
        this.service = service;
    }

    @Override
    public String call(String input) {
        logger.info("Calling service with input: " + input);
        String result = service.call(input);
        // Ruzne metody pro upravu vystupu
        logger.info("Service returned: " + result);
        return result;
    }
}
