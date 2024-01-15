package org.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.command.CopyTextCommand;
import org.observer.Customer;
import org.observer1.Profile;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        log.info("Info log!");
        log.error("Error log");
        log.warn("Warn log");
        log.debug("Debug log");

        Customer c0=new Customer(0);
        Customer c1=new Customer(1);
        Customer c2=new Customer(2);
        c0.register(c1);
        c0.register(c2);
        c0.update("Hello");

//        Profile jagr = new Profile("Jarda Jágr");
//        Profile ondra = new Profile("Milan Antoš");
//        jagr.subscribe(ondra);
//        Profile katka = new Profile("Katka Nováková");
//        jagr.subscribe(katka);
//        jagr.addPost("Ahoj hokejová rodino");
//        log.info("Ondruv feed: {}", String.join(",", ondra.getFeed()));
//        log.info("Katky feed: {}", String.join(",", katka.getFeed()));
        StringBuilder strb = new StringBuilder("Hello World");
        CopyTextCommand ctc = new CopyTextCommand(strb," Ahoj Svete");
        ctc.append();
        System.out.println(strb.toString());
        ctc.undo();
        System.out.println(strb.toString());
    }
}