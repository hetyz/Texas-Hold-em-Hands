package org.example.logic.evaluator;

import org.example.model.Card;
import org.example.model.Hand;
import org.example.model.HandType;
import org.example.model.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class TwoPairEvaluator implements HandEvaluator {
    @Override
    public Optional<Hand> evaluate(List<Card> cards) {
        Map<Rank, List<Card>> byRank = cards.stream()
                .collect(Collectors.groupingBy(Card::getRank));

        List<Rank> pairs = byRank.entrySet().stream()
                .filter(e -> e.getValue().size() >= 2)
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparingInt(Rank::getValue).reversed())
                .collect(Collectors.toList());

        if (pairs.size() >= 2) {
            Rank highPair = pairs.get(0);
            Rank lowPair = pairs.get(1);

            List<Card> kickers = cards.stream()
                    .filter(c -> c.getRank() != highPair && c.getRank() != lowPair)
                    .sorted((a, b) -> b.getRank().getValue() - a.getRank().getValue())
                    .collect(Collectors.toList());

            List<String> ranks = new ArrayList<>();
            ranks.add(highPair.toString());
            ranks.add(lowPair.toString());
            if (!kickers.isEmpty()) {
                ranks.add(kickers.get(0).getRank().toString());
            }

            return Optional.of(new Hand(HandType.TWO_PAIR.toString(), ranks.toArray(new String[0])));
        }

        return Optional.empty();
    }
}
