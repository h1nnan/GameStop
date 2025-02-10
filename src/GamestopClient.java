import Utils.Client;
import javax.swing.JOptionPane;


public class GamestopClient extends Client {
    GamestopClient(String pServerIP, int pServerPort) {
        super(pServerIP, pServerPort);
    }

    public void Game(String pName){
        this.send("Game"+ pName);
    }

    public void bestaetigen(String pAntwort){
        this.send ("BESTAETIGUNG:"+ pAntwort);
    }

    public void abmelden() {
        this.send("ABMELDEN");
    }

    public void processMessage(String pMessage) {
        JOptionPane.showMessageDialog(null,"Server sendet:\n" + pMessage);
    }

    public void sendMessageToServer() {
        String lMessage;
        lMessage = JOptionPane.showInputDialog("Bitte geben Sie eine neue Nachricht ein:");
        send(lMessage);
    }
}
