package com.testing_java.java_testing;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    // Algunas veces pasa y a veces no, esto es porque el dado arroja un numero aleatorio.
    // Para evitar eso, utilizamos mock para simular el resultado
    @Test
    public void looses_when_dado_number_is_too_low() {
        Dado dado=new Dado(6);
        System.out.println(dado.roll());
        Player player=new Player(5, dado);
        System.out.println(player.play());

        assertFalse(player.play());
    }

    @Test void  looses_when_dado_number_is_too_low_mockito(){
        Dado dado= Mockito.mock(Dado.class);
        // Cuando el dado ejecute roll, devuelva 2 (simulando resultado)
        Mockito.when(dado.roll()).thenReturn(2);

        Player player=new Player(3, dado);

        assertFalse(player.play());
    }

    @Test void wins_when_dado_number_is_bis_mockito(){
        Dado dado=Mockito.mock(Dado.class);
        Mockito.when(dado.roll()).thenReturn(4);

        Player player=new Player(4, dado);

        assertTrue(player.play());
    }
}