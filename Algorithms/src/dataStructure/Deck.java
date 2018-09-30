package dataStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
  public enum Suit {
    Club, Diamond, Spade, Heart;
  }
  
  public class Card {
    private int faceValue;
    private Suit suit;
    
    public Card(int val, Suit s) {
      this.faceValue = val;
      this.suit = s;
    }
    
    public int getValue() {
      return this.faceValue;
    }
    
    public Suit getSuit() {
      return this.suit;
    }
  }
  
  private static final Random random = new Random();
  private final List<Card> cards = new ArrayList<>();
  private int dealtIndex = 0;
  
  public Deck() {
    for (int i = 0; i <= 13; i++) {
      for (Suit suit : Suit.values()) {
        cards.add(new Card(i, suit));
      }
    }
  }
  
  public void shuffle() {
    for (int i = 0; i < cards.size(); i++) {
      int j = random.nextInt(cards.size() - i) + i;
      Card card1 = cards.get(i);
      Card card2 = cards.get(j);
      cards.set(i, card2);
      cards.set(j, card1);
    }
  }
  
  private int remainingCards() {
    return cards.size() - dealtIndex;
  }
  
  public Card[] dealHand(int number) {
    if (remainingCards() < number) {
      return null;
    }
    Card[] cards = new Card[number];
    for (int i = 0; i < number; i++) {
      cards[i] = dealCard();
    }
    
    return cards;
  }
  
  public Card dealCard() {
    if (remainingCards() == 0) {
      return null;
    }
    return cards.get(dealtIndex++);
  }
}