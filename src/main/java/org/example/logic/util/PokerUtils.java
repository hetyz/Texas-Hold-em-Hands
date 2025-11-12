package org.example.logic.util;

import org.example.model.Card;
import org.example.model.Rank;
import org.example.model.Suit;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerUtils {
    public static Map<Rank, List<Card>> groupByRank(List<Card> cards) {
        return cards.stream()
                .collect(Collectors.groupingBy(Card::getRank));
    }

    public static Map<Suit, List<Card>> groupBySuit(List<Card> cards) {
        return cards.stream()
                .collect(Collectors.groupingBy(Card::getSuit));
    }

    public static List<Rank> findRanksWithCount(Map<Rank, List<Card>> byRank, int count) {
        return byRank.entrySet().stream()
                .filter(e -> e.getValue().size() == count)
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparingInt(Rank::getValue).reversed())
                .collect(Collectors.toList());
    }

    public static List<Rank> sortedRanks(List<Card> cards) {
        return cards.stream()
                .map(Card::getRank)
                .distinct()
                .sorted(Comparator.comparingInt(Rank::getValue).reversed())
                .collect(Collectors.toList());
    }

    public static boolean hasWheel(List<Rank> ranks)
    {
        return
            ranks.contains(Rank.ACE) &&
            ranks.contains(Rank.TWO) &&
            ranks.contains(Rank.THREE) &&
            ranks.contains(Rank.FOUR) &&
            ranks.contains(Rank.FIVE);
    }
}
