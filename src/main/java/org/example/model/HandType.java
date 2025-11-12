package org.example.model;

public enum HandType {
    STRAIGHT_FLUSH("straight-flush"),
    FOUR_OF_A_KIND("four-of-a-kind"),
    FULL_HOUSE("full-house"),
    FLUSH("flush"),
    STRAIGHT("straight"),
    THREE_OF_A_KIND("three-of-a-kind"),
    TWO_PAIR("two-pair"),
    PAIR("pair"),
    NOTHING("nothing");

    private final String name;

    HandType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}