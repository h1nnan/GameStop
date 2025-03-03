import Utils.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Erstelle eine Liste von Spielen
        List<Game> orders = new List<Game>();
        Scanner scanner = new Scanner(System.in);

        Game minecraft = new Game("Minecraft", 13.55, "Mojang", true);
        Game mk1 = new Game("Mortal Kombat 1", 49.99, "Neatherreal Studios", true);
        Game subnautica = new Game("Subnautica", 29.99, "Unknown Worlds Entertainment", true);
        Game valorant = new Game("Valorant", 00.00, "Riot Games", true);
        Game fc25 = new Game("Fifa 25", 69.99, "EA Sports", false);
        Game spiderman2 = new Game("Spiderman 2", 69.99, "Insomnia Games", true);
        Game marvelrivals = new Game("Marvel Rivals", 00.00, "NetEase Games", false);
        Game l4d2 = new Game("Left 4 Dead II", 9.99, "Turtle Rock Studios Valve", true);

        // Füge die Spiele zur Liste hinzu
        orders.append(minecraft);
        orders.append(mk1);
        orders.append(subnautica);
        orders.append(valorant);
        orders.append(fc25);
        orders.append(spiderman2);
        orders.append(marvelrivals);
        orders.append(l4d2);

        // Erstelle den Server
        GamestopServer shopServer = new GamestopServer(13, orders);

        // Erstelle den Client und übergebe die Liste
        GamestopClient shopClient = new GamestopClient("10.56.18.13", 13);

        // Zeige die verfügbaren Spiele im Client an
        shopServer.processNewConnection("10.56.18.13", 13);
        shopServer.showAvailableGames(orders);
        System.out.println("Welches spiel möchtest du kaufen lil bro?");
        String inputRG = scanner.nextLine();
        shopClient.requestGame(inputRG);
        shopClient.abmelden();
        //shopServer.findGame("Minecraft");
    }
}
