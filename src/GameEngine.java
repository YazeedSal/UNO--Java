import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameEngine {
    List<Player> players = new ArrayList<>();
    Deck deck = new Deck();
    Scanner scanner = new Scanner(System.in);
    Card topCard = deck.drawCard();
    int numberOfPlayers = 2; // to ask the user after this to enter a number
    int currentTurn =0;


    GameEngine(){
        startGame();
        gameLoop();
    }

    public void startGame(){
        System.out.println("Welcome to UNO!!");

        int numberOfPlayers = 2; // You can later ask the user how many players they want
        for (int i = 1; i <= numberOfPlayers; i++) {
            String name = "";
            while (name.isBlank()) {
                System.out.println("Player " + i + ", please enter your name:");
                name = scanner.nextLine().trim();
                if (name.isBlank()) {
                    System.out.println("Name cannot be empty! Try again.");
                }
            }
            players.add(new Player(name));
        }

        for (int i = 0; i <2 ; i++) { //TODO: don't forget to return this to 7
        players.get(0).hand.add(deck.drawCard());
        players.get(1).hand.add(deck.drawCard());
        }

    }
    public void gameLoop(){
        while (!players.get(0).hasWon()&&!players.get(1).hasWon()){
            this.topCard = players.get(currentTurn%2).playTurn(topCard,scanner,deck);
            this.topCard.applyEffect(this,players.get(currentTurn));
            currentTurn = iterateTurns(currentTurn);
        }
        System.out.println("Congratsssss!!!!");
    }
    public int iterateTurns(int currentTurn){
        if (currentTurn == 1) {
            return 0;
        }else{
            return 1;
        }
    }
    public void skipNextPlayer(){
         currentTurn = iterateTurns(currentTurn);
    }

}
