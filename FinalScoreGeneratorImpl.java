import model.Person;

public class FinalScoreGeneratorImpl implements FinalScoreGenerator {

    private static final String BUSINESS = "b";
    private static final String PREMIUM = "p";

    public int getFinalScore(Person person) {
        int pointsOnAge = getPointsOnAge(person.getAge());
        int pointsOnTicketType = getPointsOnTicketType(person.getTicketType());
        int pointsOnPriority = getPointsOnPriority(person.getPriority());
        int pointsOnSpecialNeed = getPointsOnSpecialNeed(person.getSpecialNeed());
        return pointsOnAge + pointsOnPriority + pointsOnTicketType + pointsOnSpecialNeed;
    }

    @Override
    public int getPointsOnAge(int age) {
        int points = 0;

        if (age < 2) {
            points += 20;

        } else if (age < 5) {
            points += 10;

        } else if (age == 5) {
            points += 5;

        } else if (age >= 60) {
            points += 15;
        }
        return points;
    }

    @Override
    public int getPointsOnTicketType(String ticketType) {
        int points = 0;
        switch (ticketType) {
            case BUSINESS:
                points += 35;
                break;

            case PREMIUM:
                points += 20;
                break;
        }
        return points;
    }

    @Override
    public int getPointsOnPriority(boolean hasPriority) {
        int points = 0;
        if (hasPriority) {
            points += 30;
        }
        return points;
    }

    @Override
    public int getPointsOnSpecialNeed(boolean hasSpecialNeed) {
        int points = 0;
        if (hasSpecialNeed) {
            points += 100;
        }
        return points;
    }
}