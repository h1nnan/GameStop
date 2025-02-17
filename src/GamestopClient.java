import Utils.Client;
import javax.swing.JOptionPane;
import Utils.List;

public class GamestopClient extends Client {

    // Konstruktor nimmt die Liste von Spielen entgegen
    GamestopClient(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
    }



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
