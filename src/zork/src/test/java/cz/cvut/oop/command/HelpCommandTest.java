package cz.cvut.oop.command;

import cz.cvut.oop.game.GameDataImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

public class HelpCommandTest {
    @Test
    public void helpCommandTest(){
        final Map<String, Command> commands = new HashMap<>();

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

        GameDataImpl gameData = Mockito.spy(new GameDataImpl());

        String result = help.execute(null, gameData);
        Assert.assertTrue(result.contains("Všechny možné použitelné příkazy: \n" +
                "[" + commands.get("help").getName() + "]" + " - Vypíše všechny dostupné příkazy\n" +
                "[" + commands.get("reset").getName() + "]" + " - Restartuje celou hru\n" +
                "[" + commands.get("go").getName() + " 'room']" + " - Vstoupíš do místnosti 'room'\n" +
                "[" + commands.get("attack").getName() + "]" + " - Zaútočíš na nepřítele\n" +
                "[" + commands.get("take").getName() + " 'item']" + " - Sebereš 'item' do inventáře\n" +
                "[" + commands.get("look").getName() + "]" + " - Rozhlídneš se v místnosti\n" +
                "[" + commands.get("equip").getName() + " 'item']" + " - Nasadíš  si 'item' z inventáře\n" +
                "[" + commands.get("drop").getName() + " 'item']" + " - Položíš 'item' na zem\n" +
                "[" + commands.get("end").getName() + "]" + " - Ukončíš celou hru"));
    }
}
