package mn.edu.num.csa311;

import mn.edu.num.csa311.organizer.CardOrganizer;
import mn.edu.num.csa311.organizer.RecentMistakesFirstSorter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FlashcardGame {
    private List<Card> cards;
    private CLIParser config;
    private AchievementManager achManager;
    private CardOrganizer organizer;

    public FlashcardGame(List<Card> cards, CLIParser config) {
        this.cards = cards;
        this.config = config;
        this.achManager = new AchievementManager();

        if (config.invertCards) {
            for (Card c : cards)
                c.invert();
        }

        if ("recent-mistakes-first".equals(config.order)) {
            this.organizer = new RecentMistakesFirstSorter();
        } else {
            // Default: random
            this.organizer = list -> Collections.shuffle(list);
        }
    }

    public void start() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        boolean allFinished = false;

        while (!allFinished) {
            organizer.organize(cards);
            allFinished = true;
            boolean allCorrectInRound = true;
            int cardsPlayedInRound = 0;

            for (Card card : cards) {
                if (card.getCorrectCount() >= config.repetitions)
                    continue; // Зөв хариулсан тоо гүйцсэн бол алгасах

                allFinished = false;
                cardsPlayedInRound++;

                System.out.println("\nQuestion: " + card.getQuestion());
                System.out.print("Your answer: ");
                String answer = scanner.nextLine();

                if (answer.trim().equalsIgnoreCase(card.getAnswer())) {
                    System.out.println("Correct!");
                    card.recordAttempt(true);
                } else {
                    System.out.println("Incorrect. The correct answer was: " + card.getAnswer());
                    card.recordAttempt(false);
                }

                achManager.checkCardAchievements(card);
            }

            if (cardsPlayedInRound > 0 && allCorrectInRound) {
                achManager.checkRoundAchievement();
            }
        }
        System.out.println("\n🎉 Congratulations! You have learned all cards!");
        scanner.close();
    }
}