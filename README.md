# Texas-Hold-em-Hands
Description
Texas Hold'em is a Poker variant in which each player is given two "hole cards". Players then proceed to make a series of bets while five "community cards" are dealt. If there are more than one player remaining when the betting stops, a showdown takes place in which players reveal their cards. Each player makes the best poker hand possible using five of the seven available cards (community cards + the player's hole cards).

# Hands
Possible hands are, in descending order of value:

<ul>

<li>Straight-flush (five consecutive ranks of the same suit). Higher rank is better.</li>
<li>Four-of-a-kind (four cards with the same rank). Tiebreaker is first the rank, then the rank of the remaining card.</li>
<li>Full house (three cards with the same rank, two with another). Tiebreaker is first the rank of the three cards, then rank of the pair.</li>
<li>Flush (five cards of the same suit). Higher ranks are better, compared from high to low rank.</li>
<li>Straight (five consecutive ranks). Higher rank is better.</li>
<li>Three-of-a-kind (three cards of the same rank). Tiebreaker is first the rank of the three cards, then the highest other rank, then the second highest other rank.</li>
<li>Two pair (two cards of the same rank, two cards of another rank). Tiebreaker is first the rank of the high pair, then the rank of the low pair and then the rank of the remaining card.</li>
<li>Pair (two cards of the same rank). Tiebreaker is first the rank of the two cards, then the three other ranks.</li>
<li>Nothing. Tiebreaker is the rank of the cards from high to low.</li>
</ul>

# Task
Given hole cards and community cards, complete the function hand to return the type of hand (as written above, you can ignore case) and a list of ranks in decreasing order of significance, to use for comparison against other hands of the same type, of the best possible hand.


<code>// preloaded
public record Hand(String type, String[] ranks) {}</code>

<code>hand(new String[] {"A♠", "A♦"}, new String[] {"J♣", "5♥", "10♥", "2♥", "3♦"})
// ...should return new Hand("pair", new String[]{ "A", "J", "10", "5" })
hand(new String[] {"A♠", "K♦"}, new String[] {"J♥", "5♥", "10♥", "Q♥", "3♥"})
// ...should return new Hand("flush", new String[]{ "Q", "J", "10", "5", "3" })
</code>

# Notes
This section outlines some deviations from standard Texas Hold'em terminology and rules for those already familiar with the game.

<ul>
<li>For straights (and straight flushes) involving an Ace, only the ace-high straight (10-J-Q-K-A) is considered valid. An ace-low straight (A-2-3-4-5) is not recognized in this rule set, which deviates from the standard Texas Hold'em rules where both ace-high and ace-low straights are accepted. This interpretation is consistent with the author's reference solution.
~docgunthrop</li>
<li>In this kata, a Royal Flush is recognized as an Ace-high Straight Flush. The traditional distinction of Royal Flush as a separate highest hand is not applied here.</li>
<li>The term Nothing corresponds to High Card in standard poker terminology.</li>
</ul>
