package jokenpo;

import carrinho.Carrinho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JokenpoTest {

    private Jokenpo jokenpo;

    @BeforeEach
    void setup() {
        jokenpo = new Jokenpo();
    }

    @Test
    @DisplayName("Cenario de Sucesso")
    void normalJokenpoMatch() {
        int result = jokenpo.jogar(1,2);
        assertEquals(1,result);
    }


    @Test
    @DisplayName("Cenario de entradas empate")
    void drawMatch() {
        int result = jokenpo.jogar(2,2);
        assertEquals(0,result);

    }

    @Test
    @DisplayName("Entradas erradas")
    void wrongInput() {
        int result = jokenpo.jogar(4,2);
        assertEquals(-1,result);
    }

}
