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
    @DisplayName("Jogador 1 vence com papel contra pedra")
    void jogador1VencePapelVsPedra() {
        assertEquals(1, jokenpo.jogar(1, 2));
    }

    @Test
    @DisplayName("Jogador 1 vence com pedra contra tesoura")
    void jogador1VencePedraVsTesoura() {
        assertEquals(1, jokenpo.jogar(2, 3));
    }

    @Test
    @DisplayName("Jogador 1 vence com tesoura contra papel")
    void jogador1VenceTesouraVsPapel() {
        assertEquals(1, jokenpo.jogar(3, 1));
    }

    @Test
    @DisplayName("Jogador 2 vence com papel contra pedra")
    void jogador2VencePapelVsPedra() {
        assertEquals(2, jokenpo.jogar(2, 1));
    }

    @Test
    @DisplayName("Jogador 2 vence com pedra contra tesoura")
    void jogador2VencePedraVsTesoura() {
        assertEquals(2, jokenpo.jogar(3, 2));
    }

    @Test
    @DisplayName("Jogador 2 vence com tesoura contra papel")
    void jogador2VenceTesouraVsPapel() {
        assertEquals(2, jokenpo.jogar(1, 3));
    }

    @Test
    @DisplayName("Empates")
    void empates() {
        assertEquals(0, jokenpo.jogar(1, 1));
        assertEquals(0, jokenpo.jogar(2, 2));
        assertEquals(0, jokenpo.jogar(3, 3));
    }

    @Test
    @DisplayName("Entradas inválidas")
    void entradasInvalidas() {
        assertEquals(-1, jokenpo.jogar(0, 2));
        assertEquals(-1, jokenpo.jogar(4, 3));
        assertEquals(-1, jokenpo.jogar(1, 0));
        assertEquals(-1, jokenpo.jogar(2, 5));
        assertEquals(-1, jokenpo.jogar(0, 0));
        assertEquals(-1, jokenpo.jogar(-1, 7));
    }


}
