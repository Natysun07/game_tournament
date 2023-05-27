import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TournamentTest {
    @Test
    public void firstPlayerIsStronger() {
        Player Upiter = new Player(1, "Jane", 250);
        Player Venera = new Player(2, "Milly", 190);
        Game game = new Game();

        game.register(Upiter);
        game.register(Venera);

        int expected = 1;
        int actual = game.round("Jane", "Milly");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerIsWeaker() {
        Player Upiter = new Player(1, "Jane", 190);
        Player Venera = new Player(2, "Milly", 250);
        Game game = new Game();

        game.register(Venera);
        game.register(Upiter);

        int expected = 2;
        int actual = game.round("Jane", "Milly");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void resultIsDraw() {
        Player Upiter = new Player(1, "Jane", 250);
        Player Venera = new Player(2, "Milly", 250);
        Game game = new Game();

        game.register(Upiter);
        game.register(Venera);

        int expected = 0;
        int actual = game.round("Jane", "Milly");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        Player Upiter = new Player(1, "Jane", 180);
        Player Venera = new Player(2, "Milly", 250);
        Game game = new Game();

        game.register(Upiter);
        game.register(Venera);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Mikle", "Milly"));
    }

    @Test
    public void secondPlayerNotRegistered() {
        Player Upiter = new Player(1, "Jane", 250);
        Player Venera = new Player(2, "Milly", 360);
        Game game = new Game();

        game.register(Upiter);
        game.register(Venera);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Jane", "Bob"));
    }

    @Test
    public void bothPlayersNotRegistered() {
        Player Upiter = new Player(1, "Jane", 250);
        Player Venera = new Player(2, "Milly", 250);
        Game game = new Game();

        game.register(Upiter);
        game.register(Venera);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("April", "Jack"));
    }
}
