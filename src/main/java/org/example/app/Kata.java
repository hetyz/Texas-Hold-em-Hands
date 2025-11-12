package org.example.app;

import org.example.logic.evaluator.*;
import org.example.model.Card;
import org.example.model.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.example.model.Card.parseCard;

public class Kata {
    private static final List<HandEvaluator> evaluators = Arrays.asList(
            new StraightFlushEvaluator(),
            new FourOfAKindEvaluator(),
            new FullHouseEvaluator(),
            new FlushEvaluator(),
            new StraightEvaluator(),
            new ThreeOfAKindEvaluator(),
            new TwoPairEvaluator(),
            new PairEvaluator(),
            new HighCardEvaluator()
    );

    public static Hand hand(String[] holeCards, String[] communityCards) {
        List<Card> allCards = new ArrayList<>();

        for (String c : holeCards) {
            allCards.add(parseCard(c));
        }
        for (String c : communityCards) {
            allCards.add(parseCard(c));
        }

        for (HandEvaluator evaluator : evaluators) {
            Optional<Hand> result = evaluator.evaluate(allCards);
            if (result.isPresent()) return result.get();
        }

        throw new IllegalStateException("No hand found");
    }
}