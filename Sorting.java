
  public class Sorting extends Person  implements Methods{

       public  Sorting(String id, String name, int age, String ticketType, boolean priority, boolean specialNeed) {
                 super(id, name, age, ticketType, priority, specialNeed);
      }

     @Override
      public int getPointsOnAge(int age){
            int points = 0;

            if (getAge() < 2) {
                points = points + 20;

            } else if (getAge()>= 2 && getAge() < 5) {
                points = points + 10;

            } else if (getAge() <= 5 && getAge()< 10) {
                points = points + 5;

            } else if (getAge() >= 10 && getAge() < 60) {
                points = points + 0;

            } else if (getAge() >= 60) {
                points = points + 15;
            }

           return points;
      }


      @Override
      public int getPointsOnTicketType(String c){
            int points1 = 0;

            switch (c) {

                case("e"):
                   points1 = points1 + 0;
                   break;

                case("b"):
                   points1 = points1 + 35;
                   break;

                case("p"):
                   points1 = points1 + 20;
                   break;
            }

        return points1;
     }

     @Override
     public  int getPointsOnPriority(boolean boo){
         int points2 = 0 ;

         if(boo)
             points2 = points2 + 30;
          else
             points2 = 0;

        return points2;
     }

     @Override
     public int getPointsOnSpecialNeed(boolean boo1){
        int points3 = 0;

        if(boo1)
            points3 = points3 + 100;
        else
            points3 = 0;


        return points3;
     }


    int calculateTotalPoints(int AGE, String TICKET_TYPE, boolean PRIORITY, boolean SPECIAL_NEED){
        int sum = 0 ;
        sum =  sum + getPointsOnAge(AGE) + getPointsOnPriority(PRIORITY)+ getPointsOnTicketType(TICKET_TYPE) + getPointsOnSpecialNeed(SPECIAL_NEED);
        return sum;
     }





  }
