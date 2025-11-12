package org.example.app;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //System.out.println(Kata.hand(new String[]{ "A♠", "K♦" },
        //        new String[]{ "J♥", "5♥", "10♥", "Q♥", "3♥" }));
        //System.out.println(Kata.hand(new String[]{ "K♠", "Q♦" },
        //        new String[]{ "J♣", "Q♥", "9♥", "2♥", "3♦" }));
        System.out.println(Kata.hand(
                new String[]{ "A♠", "A♦" },
                new String[]{ "K♣", "K♥", "A♥", "Q♥", "3♦" }
        ));
    }
}

