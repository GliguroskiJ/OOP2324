package cz.cvut.oop.game;

import cz.cvut.oop.command.*;

import java.util.HashMap;
import java.util.Map;

/**
 *  Class represents running game instance
 *
 */
public class GameImpl implements Game {

    private final Map<String, Command> commands = new HashMap<>();
    private final GameData gameData;

    public GameImpl(){
        this.registerCommands();
        this.gameData = new GameDataImpl();
    }

    /**
     *  Method registering immutable Command instances
     *
     */
    private void registerCommands(){
        HelpCommand help = new HelpCommand(commands);
        ResetCommand reset = new ResetCommand();
        GoCommand go = new GoCommand();
        AttackCommand attack = new AttackCommand();
        TakeCommand take = new TakeCommand();
        LookCommand look = new LookCommand();
        EquipCommand equip = new EquipCommand();
        DropCommand drop = new DropCommand();
        EndCommand end = new EndCommand();

        commands.put(help.getName(), help);
        commands.put(reset.getName(), reset);
        commands.put(go.getName(), go);
        commands.put(attack.getName(), attack);
        commands.put(take.getName(), take);
        commands.put(look.getName(), look);
        commands.put(equip.getName(), equip);
        commands.put(drop.getName(), drop);
        commands.put(end.getName(), end);
    }

    /**
     *  Method returns welcome message which should be printed right after
     *  game is started
     */
    @Override
    public String welcomeMessage() {
        return "Pokud si nebudeš kdykoliv vědět rady co za příkaz máš použít ---> použij prosím příkaz 'help'.\n" +
                "<-------------------------------------------------------------------------------------------->\n" +
                "Ocitl si se v relativně tmavé chodbě, kde ze dveří naproti prosvíta světlo až na tebe.\n" +
                "Jediné co si pamatuješ je, že si chtěl pár drobných na jídlo a vešel si do domu\n" +
                "s nápisem na dveřích - 'The strange rich family'.\n" +
                "Začni nejlépe příkazem 'look'";
    }

    /**
     *  Method returns end message which should be printed right after
     *  game is finished
     */
    @Override
    public String endMessage() {
        return "Hra skončila, pro nový pokus spusť prosím hru znovu";
    }

    /**
     *  Method parses input line and should divide its parts to command name
     *  and array of input arguments (0-N). Based on parsed command name,
     *  specific command should be looked up and executed. If none is found,
     *  default message should be returned
     */
    @Override
    public String processTextCommand(String line) {
        String result;
        String[] args = line.split(" ");
        Command command = commands.getOrDefault(args[0], null);
        if(command != null){
            result = command.execute(args, gameData);
        }
        else{
            result = "Neznámý příkaz, zkuste jiný nebo vyzkoušejte příkaz 'help'";
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
