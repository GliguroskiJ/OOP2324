package org.mock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MockInterfaceTest {
    @Test
    public void testDoSomething()
    {
        // Vytvoření mock objektu
        MockInterface myMockService = mock(MockInterface.class);
        // Nastavení chování mock objektu
        when(myMockService.doSomething()).thenReturn("Mock Response");
        // testovani
        String response=myMockService.doSomething();
        assertEquals("Mock Response",response);
        // Ověření, zda byla metoda volána
        verify(myMockService).doSomething();
    }
}
