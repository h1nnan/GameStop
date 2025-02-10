import Utils.List;
import Utils.Server;
import java.util.Scanner;

public class GamestopServer extends Server {
    public List<Order> orders;

    GamestopServer (int pPortnummer){
        super(pPortnummer);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {

    }

    private void processNewMessage(String pCLientIP, int pClientPort){
       this.send(pCLientIP, pClientPort, "Willkommen bei Gamestop!! Welches Spiel wollen sie haben");
    }

    public void processMessage(String pClientIP, int pClientPort, String pMessage){
        //Implementiere hier


    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {

    }

    public void processClosedConnection(String pClient, int pClientPort){

    }

}
