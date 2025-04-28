public class Card{
    private String color;
    private int value;
    //Constructors
    Card(String color, int value){
        this.color = color;
        this.value = value;
    }
    //Methods
    public boolean isPlayable(Card topCard){
        return this.color.equals(topCard.color)|| this.value == topCard.value;
    }
    public String toString() {
        return this.value +","+this.color;
    }
}
