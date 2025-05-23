import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards ;
    //Constructors
    Deck(){
        this.cards = new ArrayList<>();
        initializeDeck();
        Collections.shuffle(cards);
    }
    //Methods
    private void initializeDeck(){
        String[] colors = {"Red","Green","Blue","Yellow"};
        for (String color: colors) {
            cards.add(new Card(color, 0));
            cards.add(new SkipCard(color));
            cards.add(new SkipCard(color));

            for (int i = 1; i <= 2; i++) { // TODO: return this to 9
                cards.add(new Card(color, i));
                cards.add(new Card(color, i));
            }

        }
    }
    public Card drawCard(){
        if (cards.isEmpty()){
            return null;
        }
        return cards.remove(0);
    }
}
