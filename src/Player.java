    import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    public int id;
    public List<Card> hand;

    //Constructors
    Player(String name){
        this.name = name;
        this.hand = new ArrayList<>();
        this.id = (int)(Math.random() * 101);;
    }
    //Methods
    public String getName(){
        return this.name;
    }
    public void drawCard(Deck deck){
        Card card = deck.drawCard();
        if (card!=null){
            hand.add(card);
            System.out.println(this.name+" drew a card: "+ card);
        }
    }
    public boolean hasWon(){
        if (hand.isEmpty())
            return true;
        return false;
    }

    public Card playTurn(Card topCard, Scanner scanner, Deck deck) {
        System.out.println(name + ", your hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + ": " + hand.get(i));
        }

        System.out.println("Top card on pile: " + topCard);
        boolean validInput = false;
        int choice = -1;
        while (!validInput) {
            try {
                choice = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // <-- IMPORTANT: clear the bad input
            }
        }


        if (choice >= 0 && choice < hand.size()) {
            Card chosen = hand.get(choice);
            if (chosen.isPlayable(topCard)) {
                System.out.println(name + " played: " + chosen);
                topCard = hand.get(choice);
                hand.remove(choice);
                return topCard;
            } else {
                System.out.println("Invalid card! You must draw.");
                hand.add(deck.drawCard());
                return topCard;
            }
        }
        hand.add(deck.drawCard());
        return topCard;// Must draw
    }
}
