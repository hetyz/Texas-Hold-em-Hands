package org.example.logic.evaluator;

import org.example.logic.util.PokerUtils;
import org.example.model.Card;
import org.example.model.Hand;
import org.example.model.HandType;
import org.example.model.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class PairEvaluator implements HandEvaluator {
    @Override
    public Optional<Hand> evaluate(List<Card> cards) {
        Map<Rank, List<Card>> byRank = PokerUtils.groupByRank(cards);
        List<Rank> pairs = PokerUtils.findRanksWithCount(byRank, 2);

        if (!pairs.isEmpty()) {
            Rank pairRank = pairs.get(0);
            List<Card> kickers = cards.stream()
                    .filter(c -> c.getRank() != pairRank)
                    .sorted((a, b) -> b.getRank().getValue() - a.getRank().getValue())
                    .collect(Collectors.toList());

            List<String> ranks = new ArrayList<>();
            ranks.add(pairRank.toString());
            for (int i = 0; i < Math.min(3, kickers.size()); i++) {
                ranks.add(kickers.get(i).getRank().toString());
            }

            return Optional.of(new Hand(HandType.PAIR.toString(), ranks.toArray(new String[0])));
        }
        return Optional.empty();
    }
}
