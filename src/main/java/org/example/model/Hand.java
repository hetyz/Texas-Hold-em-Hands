package org.example.model;

import java.util.Arrays;

public class Hand {
    private final String type;
    private final String[] ranks;

    public Hand(String type, String[] ranks) {
        this.type = type;
        this.ranks = ranks;
    }

    public String getType() {
        return type;
    }

    public String[] getRanks() {
        return ranks;
    }

    @Override
    public String toString() {
        return type + " " + Arrays.toString(ranks);
    }
}
