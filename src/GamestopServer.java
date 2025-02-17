import Utils.List;
import Utils.Server;
import javax.swing.*;

public class GamestopServer extends Server {
    public List<Game> ListOrders;

    public GamestopServer(int pPortnummer, List<Game> ListOrders) {
        super(pPortnummer);
        this.ListOrders = new List<Game>();
    }



    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {

    }

    private void processNewMessage(String pCLientIP, int pClientPort){
       this.send(pCLientIP, pClientPort, "Willkommen bei Gamestop!! Welches Spiel wollen sie haben");
    }

    public Game findGame(String pMessage) {
        while (ListOrders.hasAccess()) {
            if (pMessage.equals(ListOrders.getContent().getName())){
                return ListOrders.getContent();
            }
            ListOrders.next();
        }
        return null;
    }

    public void showAvailableGames() {
        StringBuilder gamesList = new StringBuilder("Available Games:\n");

        ListOrders.toFirst();  // Move to the start of the list
        while (ListOrders.hasAccess()) {
            Game game = ListOrders.getContent();
            gamesList.append(game.getName()).append(" - ").append(game.getPrice()).append("€\n");
            ListOrders.next();
        }

        JOptionPane.showMessageDialog(null, gamesList.toString());
    }

    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        if (ListOrders == null) {
            this.send(pClientIP, pClientPort, "Fehler: Bestellungen sind nicht initialisiert.");
            return;
        }

        if (pMessage.startsWith("REQUEST_GAME:")) {
            String gameName = pMessage.substring(13).trim();
            Game requestedGame = findGame(gameName);

            if (requestedGame != null) {
                String response = "Spiel gefunden: " + requestedGame.getName() +
                        " | Preis: " + requestedGame.getPrice() + "€" +
                        " | Entwickler: " + requestedGame.getDevs() +
                        " | Verfügbar: " + (requestedGame.isInStock() ? "Ja" : "Nein");
                this.send(pClientIP, pClientPort, response);
            } else {
                this.send(pClientIP, pClientPort, "Fehler: Spiel nicht gefunden.");
            }
        } else if (pMessage.equals("ABMELDEN")) {
            this.send(pClientIP, pClientPort, "Sie wurden abgemeldet.");
            processClosedConnection(pClientIP, pClientPort);
        } else {
            this.send(pClientIP, pClientPort, "Unbekannte Anfrage.");
        }
    }



    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }

    public void processClosedConnection(String pClient, int pClientPort){

    }

}
