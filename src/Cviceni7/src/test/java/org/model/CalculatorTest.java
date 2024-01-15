package org.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import static org.junit.jupiter.api.Assertions.assertTrue;
public class CalculatorTest {

    Calculator calculator;
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    @Test
    public void testMultiply()
    {
//        calculator=new Calculator();
        assertEquals(5,calculator.multiply(5,1));
    }

    @Test
    public void testMultiply2A()
    {
//        calculator=new Calculator();
        assertEquals(16,calculator.multiply2(4,2));
    }

    @Test
    public void testMultiply2B()
    {
//        calculator=new Calculator();
        assertEquals(10,calculator.multiply2(6,2));
    }
    @Test
    public void testMultiply2C()
    {
//        calculator=new Calculator();
    assertEquals(5,calculator.multiply2(5,5));
    }

    @Test
    public void testMultiply2X()
    {
//        calculator=new Calculator();
        assertEquals(5,calculator.multiply2(5,5));
        assertEquals(16,calculator.multiply2(4,2));
        assertEquals(10,calculator.multiply2(6,2));
        assertEquals(-1000,calculator.multiply2(5,6));
        assertEquals(0,calculator.multiply2(11,1));
    }

    @Test
    public void testIsEven()
    {
//        calculator= new Calculator();
//        assertTrue(calculator.isEven(6));
        assertTrue(calculator.isEven(6));
    }
//    assertEquals(10,calculator.multiply(6,2));

//    assertEquals(-1000,calculator.multiply(5,6));
//    assertEquals(5,calculator.multiply(11,1));
}
