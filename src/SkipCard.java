public class SkipCard extends Card{
    public final int SKIP = 10;
    SkipCard(String color){
        super(color,10);
    }
    public void applyEffect(GameEngine engine, Player player){
        engine.skipNextPlayer();
    }
}
