public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Player " + playerName + " not found");
    }
}
