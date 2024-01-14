package cz.cvut.oop.command;

import cz.cvut.oop.game.GameDataImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EndCommandTest {
    @Test
    public void endCommandTest(){
        EndCommand end = new EndCommand();

        GameDataImpl gameData = Mockito.spy(new GameDataImpl());

        String result = end.execute(null, gameData);
        Assert.assertTrue(result.contains("Hra byla ukončena"));
        Assert.assertTrue(gameData.isFinished());

    }
}
