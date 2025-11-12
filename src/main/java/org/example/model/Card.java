package org.example.model;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }

    public static Card parseCard(String cardStr) {
        String rankPart = cardStr.substring(0, cardStr.length() - 1);
        String suitPart = cardStr.substring(cardStr.length() - 1);
        return new Card(Rank.fromString(rankPart), Suit.fromSymbol(suitPart));
    }
}
