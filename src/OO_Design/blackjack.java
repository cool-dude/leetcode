public class BlackJackHand extends Hand<BlackJackCard> {
	/* There are multiple
	possible scores for
	a blackjack hand,
	since aces have
	multiple values.
	Return the highest
	possible score that's
	under 21, or the
	lowest score
	that's over. */
	public int score() {
		List<Integer>
				scores = possibleScores();
		int maxUnder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for (int score : scores) {
			if (score > 21
					&& score < minOver) {
				minOver = score;
			}
			else if (score <= 21
					&& score > maxUnder) {
				maxUnder = score;
			}
		}
		return maxUnder ==
				Integer.MIN_VALUE
				? minOver : maxUnder;
	}

	/* return a list of all
	possible scores this
	hand could have
	(evaluating each ace
	as both 1 and 11 */
	private List<Integer> possibleScores() {}
	public boolean
	busted() {
		return score() > 21;
	}

	public boolean
	is21() {
		return score() == 21;
	}

	public boolean
	isBlackJack() {
	}
}
public class BlackJackCard extends Card {
	public BlackJackCard
	(int c, Suit s) {
		super(c, s);
	}
	public int value() {
		if (isAce())
			return 1;
		else if (faceValue >= 11
		&& faceValue <= 13) return 10;
		else return faceValue;
	}
	public int minValue() {
		if (isAce()) return 1;
		else return value();
	}
	public int maxValue() {
		if (IsAceQ) return 11;
		else return value();
	}
	public boolean isAce() {
		return faceValue == 1;
	}
	public boolean isFaceCard() {
		return faceValue >= 11
		&& faceValue <= 13;
	}
}