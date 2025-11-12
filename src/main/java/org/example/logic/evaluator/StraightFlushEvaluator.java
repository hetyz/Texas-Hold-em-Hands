package org.example.logic.evaluator;

import org.example.logic.util.PokerUtils;
import org.example.model.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StraightFlushEvaluator implements HandEvaluator {
    @Override
    public Optional<Hand> evaluate(List<Card> cards) {
        Map<Suit, List<Card>> bySuit = PokerUtils.groupBySuit(cards);

        for (List<Card> suitedCards : bySuit.values()) {
            if (suitedCards.size() >= 5) {
                List<Rank> sortedRanks = PokerUtils.sortedRanks(cards);

                if (PokerUtils.hasWheel(sortedRanks)) {
                    return Optional.of(new Hand(HandType.STRAIGHT_FLUSH.toString(), new String[]{"5", "4", "3", "2", "A"}));
                }

                for (int i = 0; i <= sortedRanks.size() - 5; i++) {
                    int start = sortedRanks.get(i).getValue();
                    boolean isStraight = true;
                    for (int j = 1; j < 5; j++) {
                        if (sortedRanks.get(i + j).getValue() != start - j) {
                            isStraight = false;
                            break;
                        }
                    }
                    if (isStraight) {
                        String[] ranks = sortedRanks.subList(i, i + 5).stream()
                                .map(Rank::toString)
                                .toArray(String[]::new);
                        return Optional.of(new Hand(HandType.STRAIGHT_FLUSH.toString(), ranks));
                    }
                }
            }
        }
        return Optional.empty();
    }
}
