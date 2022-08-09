package ru.netology.javaqa.javaqamvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(1, "Никита", 753);
    Player player2 = new Player(2, "Василий", 321);
    Player player3 = new Player(3, "Сергей", 753);

    @Test
    public void shouldReturnWin1() {

        game.register(player1);
        game.register(player2);

        int actual = game.round(player1.getName(), player2.getName());
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnWin2() {

        game.register(player1);
        game.register(player2);

        int actual = game.round(player2.getName(), player1.getName());
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnDraw() {

        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round(player1.getName(), player3.getName());
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void shouldTrowsExceptionPlayer1NotReg() {

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }

    @Test
    public void shouldTrowsExceptionPlayer2NotReg() {

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }
}
