import Utils.Client;
import javax.swing.JOptionPane;
import Utils.List;

public class GamestopClient extends Client {
    private List<Game> availableGames;  // Liste der verfügbaren Spiele

    // Konstruktor nimmt die Liste von Spielen entgegen
    GamestopClient(String pServerIP, int pServerPort, List<Game> availableGames) {
        super(pServerIP, pServerPort);
        this.availableGames = availableGames;  // Liste speichern
    }

    // Zeigt die verfügbaren Spiele an
    public void showAvailableGames() {
        StringBuilder gamesList = new StringBuilder("Available Games:\n");

        availableGames.toFirst();  // Move to the start of the list
        while (availableGames.hasAccess()) {
            Game game = availableGames.getContent();
            gamesList.append(game.getName()).append(" - ").append(game.getPrice()).append("€\n");
            availableGames.next();
        }

        JOptionPane.showMessageDialog(null, gamesList.toString());
    }


    // Weitere Methoden zum Kommunizieren mit dem Server
    public void requestGame(String gameName) {
        this.send("REQUEST_GAME:" + gameName);  // Sendet den Namen des Spiels
    }

    public void confirmGame(String confirmation) {
        this.send("CONFIRM_GAME:" + confirmation);  // Sendet die Bestätigung an den Server
    }

    public void abmelden() {
        this.send("ABMELDEN");
    }

    public void processMessage(String pMessage) {
        JOptionPane.showMessageDialog(null, "Server sendet:\n" + pMessage);
    }
}
