package cz.cvut.oop.command;

import cz.cvut.oop.game.GameDataImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ResetCommandTest {

    @Test
    public void resetCommandTest(){
        ResetCommand reset = new ResetCommand();

        GameDataImpl gameData = Mockito.spy(new GameDataImpl());

        String result = reset.execute(null, gameData);
        Assert.assertTrue(result.contains("hra uspesne resetovana."));
        Mockito.verify(gameData, Mockito.times(1)).init();
    }
}
