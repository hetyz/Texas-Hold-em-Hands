package org.example.logic.evaluator;

import org.example.logic.util.PokerUtils;
import org.example.model.Card;
import org.example.model.Hand;
import org.example.model.HandType;
import org.example.model.Rank;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FullHouseEvaluator implements HandEvaluator {
    @Override
    public Optional<Hand> evaluate(List<Card> cards) {
        Map<Rank, List<Card>> byRank = PokerUtils.groupByRank(cards);
        List<Rank> triples = PokerUtils.findRanksWithCount(byRank, 3);
        List<Rank> pairs = PokerUtils.findRanksWithCount(byRank, 2);

        if (!triples.isEmpty() && pairs.size() > 1 || (pairs.size() == 1 && triples.size() == 1 && !pairs.get(0).equals(triples.get(0)))) {
            Rank tripleRank = triples.get(0);
            Rank pairRank = pairs.stream()
                    .filter(r -> r != tripleRank)
                    .findFirst()
                    .orElse(null);

            if (pairRank != null) {
                String[] ranks = {tripleRank.toString(), pairRank.toString()};
                return Optional.of(new Hand(HandType.FULL_HOUSE.toString(), ranks));
            }
        }
        return Optional.empty();
    }
}

