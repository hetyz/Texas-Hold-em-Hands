package org.example.logic.evaluator;

import org.example.model.Card;
import org.example.model.Hand;
import org.example.model.HandType;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HighCardEvaluator implements HandEvaluator {
    @Override
    public Optional<Hand> evaluate(List<Card> cards) {
        List<Card> sorted = cards.stream()
                .sorted((a, b) -> b.getRank().getValue() - a.getRank().getValue())
                .collect(Collectors.toList());

        String[] ranks = sorted.stream()
                .limit(5)
                .map(c -> c.getRank().toString())
                .toArray(String[]::new);

        return Optional.of(new Hand(HandType.NOTHING.toString(), ranks));
    }
}
