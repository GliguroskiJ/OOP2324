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
        return "Můžeme znovu vytisknout úvodní příběh, možné příkazy: \n" +
                "[" + commands.get("help").getName() + "]" + " - Vypíše všechny dostupné příkazy\n" +
                "[" + commands.get("reset").getName() + "]" + " - Restartuje celou hru\n" +
                "[" + commands.get("go").getName() + " 'room']" + " - Vstoupíš do místnosti 'room'\n" +
                "[" + commands.get("attack").getName() + "]" + " - Zaútočíš na nepřítele\n" +
                "[" + commands.get("take").getName() + " 'item']" + " - Sebereš 'item' do inventáře\n" +
                "[" + commands.get("look").getName() + "]" + " - Rozhlídneš se v místnosti\n" +
                "[" + commands.get("equip").getName() + " 'item']" + " - Nasadíš  si 'item' z inventáře\n" +
                "[" + commands.get("drop").getName() + " 'item']" + " - Položíš 'item' na zem\n" +
                "[" + commands.get("end").getName() + "]" + " - Ukončíš celou hru";
    }
}

