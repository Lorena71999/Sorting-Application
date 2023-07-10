public interface FinalScoreGenerator {

    int getPointsOnAge(int age);
    int getPointsOnTicketType(String ticketType);
    int getPointsOnPriority(boolean hasPriority);
    int getPointsOnSpecialNeed(boolean hasSpecialNeed);
}
