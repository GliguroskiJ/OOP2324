package model;

import org.example.model.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator;
    @Test

    public void testMultiply()
    {
        calculator = new Calculator();
        assertEquals(8, calculator.nasobeniAB(4,1));
        assertEquals(13, calculator.nasobeniAB(7,3));
        assertEquals(11, calculator.nasobeniAB(11,11));
        assertEquals(-1000, calculator.nasobeniAB(100,1000));
        assertEquals(0, calculator.nasobeniAB(30,2));
    }
}
