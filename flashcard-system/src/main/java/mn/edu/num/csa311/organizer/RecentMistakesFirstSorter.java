package mn.edu.num.csa311.organizer;

import java.util.Comparator;
import java.util.List;
import mn.edu.num.csa311.Card;

public class RecentMistakesFirstSorter implements CardOrganizer {
    @Override
    public void organize(List<Card> cards) {
        cards.sort(Comparator.comparing(Card::isLastAttemptFailed).reversed());
    }
}