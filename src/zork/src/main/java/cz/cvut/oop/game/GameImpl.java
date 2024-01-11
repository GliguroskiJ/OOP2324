package cz.cvut.oop.game;

import cz.cvut.oop.command.Command;
import cz.cvut.oop.command.GoCommand;
import cz.cvut.oop.command.HelpCommand;
import cz.cvut.oop.command.ResetCommand;

import java.util.HashMap;
import java.util.Map;

/**
 *  Class represents running game instance
 *
 */
public class GameImpl implements Game {

    private Map<String, Command> commands = new HashMap<>();
    private GameData gameData;

    public GameImpl(){
        this.registerCommands();
        this.gameData = new GameDataImpl();
    }

    /**
     *  Method registering immutable Command instances
     *
     */
    private void registerCommands(){
        Command help = new HelpCommand(commands);
        Command reset = new ResetCommand();
        GoCommand go = new GoCommand();
        commands.put(help.getName(), help);
        commands.put(reset.getName(), reset);
        commands.put(go.getName(), go);
    }

    /**
     *  Method returns welcome message which should be printed right after
     *  game is started
     */
    @Override
    public String welcomeMessage() {
        //TODO doplnit pořádnou uvítací hlášku
        return "Startovní hláška hry, pokud nevíte co a jak, \n" +
                "použijte příkaz 'nápověda' \n"
                + gameData.getCurrentRoom().getDescription();
    }

    /**
     *  Method returns end message which should be printed right after
     *  game is finished
     */
    @Override
    public String endMessage() {
        //TODO doplnit pořádnou koncovou hlášku
        return "Koncová hláška";
    }

    /**
     *  Method parses input line and should divide its parts to command name
     *  and array of input arguments (0-N). Based on parsed command name,
     *  specific command should be looked up and executed. If none is found,
     *  default message should be returned
     */
    @Override
    public String processTextCommand(String line) {
        //TODO zpracovat z řádku příkaz a argumenty a naplnit kde je to potřeba
        String result;
        String[] args = line.split(" ");
        Command command = commands.getOrDefault(args[0], null);
        if(command != null){
            result = command.execute(null, gameData);
        }
        else{
            result = "Neznámý příkaz, zkuste jiný nebo vyzkoušejte příkaz 'nápověda'";
        }
        return result;
    }

    /**
     *  Method delegates its call to mutable GameData instance, which hold current game state. This
     *  state should be checked after each command evaluation a possibly terminate whole app if
     *  true is returned
     */
    @Override
    public boolean isFinished() {
        return gameData.isFinished();
    }
}
