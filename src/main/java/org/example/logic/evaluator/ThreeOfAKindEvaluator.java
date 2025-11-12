package org.example.logic.evaluator;

import org.example.logic.util.PokerUtils;
import org.example.model.Card;
import org.example.model.Hand;
import org.example.model.HandType;
import org.example.model.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeOfAKindEvaluator implements HandEvaluator{
    @Override
    public Optional<Hand> evaluate(List<Card> cards) {
        Map<Rank, List<Card>> byRank = PokerUtils.groupByRank(cards);
        List<Rank> triples = PokerUtils.findRanksWithCount(byRank, 3);

        if (!triples.isEmpty()) {
            Rank tripleRank = triples.get(0);
            List<Card> kickers = cards.stream()
                    .filter(c -> c.getRank() != tripleRank)
                    .sorted((a, b) -> b.getRank().getValue() - a.getRank().getValue())
                    .collect(Collectors.toList());

            List<String> ranks = new ArrayList<>();
            ranks.add(tripleRank.toString());
            for (int i = 0; i < Math.min(2, kickers.size()); i++) {
                ranks.add(kickers.get(i).getRank().toString());
            }

            return Optional.of(new Hand(HandType.THREE_OF_A_KIND.toString(), ranks.toArray(new String[0])));
        }
        return Optional.empty();
    }
}
