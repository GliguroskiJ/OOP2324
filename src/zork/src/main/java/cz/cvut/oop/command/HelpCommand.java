package cz.cvut.oop.command;

import cz.cvut.oop.game.GameData;

import java.util.Map;

public class HelpCommand implements Command {

    private Map<String, Command> commands;

    public HelpCommand(Map<String, Command> commands){
        this.commands = commands;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String execute(String[] arguments, GameData gameData) {
        return "Můžeme znovu vytisknout úvodní příběh, možné příkazy: " + commands.keySet().toString();
    }
}

