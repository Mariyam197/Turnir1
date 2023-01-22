package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();


    @Test
    public void whenFistPlayerIsMoreStrength() {
        Player player1 = new Player(1, "Kim", 40);
        Player player2 = new Player(2, "Tomas", 23);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Kim", "Tomas");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenSecondPlayerIsMoreStrength() {
        Player player1 = new Player(1, "Kim", 40);
        Player player2 = new Player(2, "Tomas", 65);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Kim", "Tomas");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenPlayersAreDraw() {
        Player player1 = new Player(1, "Kim", 40);
        Player player2 = new Player(2, "Tomas", 40);

        game.register(player1);
        game.register(player2);

        int actual = game.round("Kim", "Tomas");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerIsNotRegistered() {

        Player player1 = new Player(1, "Kim", 40);
        Player player2 = new Player(2, "Tomas", 25);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Kim", "Tomas"));
    }

    @Test
    public void whenSecondPlayerIsNotRegistered() {
        Player player1 = new Player(1, "Kim", 40);
        Player player2 = new Player(2, "Tomas", 25);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Kim", "Tomas"));
    }

    @Test
    public void whenPlayersAreNotRegistered() {
        Player player1 = new Player(1, "Kim", 40);
        Player player2 = new Player(2, "Tomas", 25);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Kim", "Tomas"));
    }

}
