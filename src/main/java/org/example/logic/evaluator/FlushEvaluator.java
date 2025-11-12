package org.example.logic.evaluator;

import org.example.logic.util.PokerUtils;
import org.example.model.Card;
import org.example.model.Hand;
import org.example.model.HandType;
import org.example.model.Suit;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FlushEvaluator implements HandEvaluator {
    @Override
    public Optional<Hand> evaluate(List<Card> cards) {
        Map<Suit, List<Card>> bySuit = PokerUtils.groupBySuit(cards);

        for (List<Card> suitedCards : bySuit.values()) {
            if (suitedCards.size() >= 5) {
                suitedCards.sort((a, b) -> b.getRank().getValue() - a.getRank().getValue());
                List<Card> bestFive = suitedCards.subList(0, 5);
                String[] ranks = bestFive.stream()
                        .map(c -> c.getRank().toString())
                        .toArray(String[]::new);
                return Optional.of(new Hand(HandType.FLUSH.toString(), ranks));
            }
        }
        return Optional.empty();
    }
}
