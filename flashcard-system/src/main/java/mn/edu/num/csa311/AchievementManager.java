package mn.edu.num.csa311;

public class AchievementManager {
    public void checkCardAchievements(Card card) {
        if (card.getTotalAttempts() == 6) {
            System.out.println("---ACHIEVEMENT UNLOCKED: [REPEAT] Answered a card more than 5 times.---");
        }
        if (card.getCorrectCount() == 3) {
            System.out.println("---ACHIEVEMENT UNLOCKED: [CONFIDENT] Answered a card correctly 3 times.---");
        }
    }

    public void checkRoundAchievement() {
        System.out.println("---ACHIEVEMENT UNLOCKED: [CORRECT] You answered all cards correctly in the last round!---");
    }
}