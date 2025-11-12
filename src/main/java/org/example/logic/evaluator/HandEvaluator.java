package org.example.logic.evaluator;

import org.example.model.Card;
import org.example.model.Hand;

import java.util.List;
import java.util.Optional;

public interface HandEvaluator {
    Optional<Hand> evaluate(List<Card> cards);
}
