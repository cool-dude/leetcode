public enum Suit {
    Club (0), Diamond (1), Heart (2), Spade (3);
    private int val;
    private Suit(int v) { val = v; }
    public int getVal() { return val; }
    public static Suit getSuitFromValue(int value) {}
}
public abstract class Card {
    private boolean available = true;
    /* number or face
    that's on card - a number
    2 through 10, or 11
    * for Jack, 12 for
    Queen, 13 for King,
    or 1 for Ace */
    protected int faceValue;
    protected Suit suit;
    public Card(int c, Suit s) {
        faceValue = c;
        suit = s;
    }
    public abstract int value();
    public Suit suit() {
        return suit;
    }
    /* Checks if the card is
	available to be given out
	to someone */
    public boolean isAvailable() {
        return available;
    }
    public void markUnavailable() {
        available = false;
    }
    public void markAvailable() {
        available = true;
    }
}
public class Deck<T extends Card> {
    private ArrayList<T> cards;
    //all cards, dealt or not
    private int dealtlndex = 0;
    //marks first undealt card
    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        cards=deckOfCards;
    }
    public void shuffle() {}
    public int remainingCards()
    {
        return cards.size() - dealtlndex;
    }
    public T[] dealHand(int number) {}
    public T dealCard() {
    }
}
public class Hand<T extends Card> {
    protected ArrayList<T> cards = new ArrayList<T>();
    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }
        return score;
    }
    public void addCard(T card) {
        cards.add(card);
    }
}