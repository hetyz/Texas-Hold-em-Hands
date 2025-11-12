package org.example.model;

public enum Rank {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
    SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(11), QUEEN(12), KING(13), ACE(14);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        switch (this) {
            case JACK: return "J";
            case QUEEN: return "Q";
            case KING: return "K";
            case ACE: return "A";
            default: return String.valueOf(value);
        }
    }

    public static Rank fromString(String s) {
        switch (s) {
            case "A": return ACE;
            case "K": return KING;
            case "Q": return QUEEN;
            case "J": return JACK;
            case "10": return TEN;
            case "9": return NINE;
            case "8": return EIGHT;
            case "7": return SEVEN;
            case "6": return SIX;
            case "5": return FIVE;
            case "4": return FOUR;
            case "3": return THREE;
            case "2": return TWO;
            default: throw new IllegalArgumentException("Invalid rank: " + s);
        }
    }
}