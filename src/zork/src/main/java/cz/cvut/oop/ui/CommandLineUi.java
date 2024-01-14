package cz.cvut.oop.ui;

import cz.cvut.oop.game.Game;
import cz.cvut.oop.game.GameImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 *  Represents command line ui view
 */
public class CommandLineUi {
    private static final Logger log = LoggerFactory.getLogger(CommandLineUi.class);
    private static CommandLineUi INSTANCE;
    private final Game game = new GameImpl();

    private CommandLineUi(){
        //this.game = new GameImpl();
    }

    public static CommandLineUi getInstance(){
        if (INSTANCE == null) INSTANCE = new CommandLineUi();
        return INSTANCE;
    }
    /**
     *  After ui is started, application prints welcome messages and waits for user input
     *  then proceeds to process user input and return messages back here
     *  -> to be represented on this view.
     */
    public void start(){
        log.info("application started");
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println(this.game.welcomeMessage());
            while(!this.game.isFinished()){
                System.out.print("> ");
                String userInput = scanner.nextLine();
                log.info(userInput);
                System.out.println(this.game.processTextCommand(userInput));
            }
            System.out.println(this.game.endMessage());
            log.info("application ended");
        }
    }

}
