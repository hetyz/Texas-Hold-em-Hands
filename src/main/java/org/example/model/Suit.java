package org.example.model;

public enum Suit {
    SPADES("♠"), HEARTS("♥"), DIAMONDS("♦"), CLUBS("♣");

    private final String symbol;

    Suit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static Suit fromSymbol(String s) {
        switch (s) {
            case "♠": return SPADES;
            case "♥": return HEARTS;
            case "♦": return DIAMONDS;
            case "♣": return CLUBS;
            default: throw new IllegalArgumentException("Invalid suit: " + s);
        }
    }
}
