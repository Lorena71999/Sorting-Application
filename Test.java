import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {

        List<Sorting> personList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("queue.txt"));
        String line = null;

        int n = Integer.parseInt(String.valueOf(br.readLine().charAt(0)));
        int i = 0;
        ArrayList<String> vector = new ArrayList<>();

        while ((line = br.readLine()) != null && i < n) {
            i++;
            vector.add(line);
        }

        for (int k = 0; k < n; k++) {
            String[] s = vector.get(k).split(" ");
            String id1 = s[0];
            String name1 = s[1];
            int age1 = Integer.parseInt(s[2]);
            String ticketType1 = s[3];
            boolean priority1 = Boolean.parseBoolean(s[4]);
            boolean specialNeed1 = Boolean.parseBoolean(s[4]);personList.add(new Sorting(id1, name1, age1, ticketType1, priority1, specialNeed1));

        }


        Map<String, Double> hashmap = new HashMap<>();//aici calculez prioritatea pentru fiecare id
        for (Sorting person : personList) {

            String key = person.getId();
           // int nr1 = 0, nr2 = 0;
            double price = hashmap.containsKey(key) ? hashmap.get(key) : 0;
            price += person.calculateTotalPoints(person.getAge(), person.getTicketType(), person.getPriority(), person.getSpecialNeed());
            hashmap.put(key, price);
        }

        System.out.println("");
        for (String key1 : hashmap.keySet()) {
            if (key1.startsWith("f"))
                hashmap.replace(key1, hashmap.get(key1) + 10);
            else if (key1.startsWith("g"))
                hashmap.replace(key1, hashmap.get(key1) + 5);

        }

        ArrayList<Passenger> pasageri = new ArrayList<>();//vector de pasageri
        for (String key1 : hashmap.keySet()) {
            pasageri.add(new Passenger(key1, hashmap.get(key1)));

        }

        PriorityQueue<Passenger> pr = new PriorityQueue<Passenger>();
        ArrayList<String> command = new ArrayList<>();
        int j = n;

        while ((line = br.readLine()) != null) {
            command.add(line);
            j++;
        }

        try {
            FileWriter myWriter = new FileWriter("queue_out.txt");

            for (int q = 0; q < command.size(); q++) {

                if (command.get(q).contains("insert")) {
                    String[] subcommand = command.get(q).split(" ");
                    pr.insert(new Passenger(subcommand[1], hashmap.get(subcommand[1])));
                }

                if (command.get(q).equalsIgnoreCase("embark")) {
                    pr.embark();
                }

                if (command.get(q).equalsIgnoreCase("list")) {
                    myWriter.flush();
                    myWriter.write(pr.list());
                    System.out.println(pr.list());
                }

            }

            myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }finally {
               br.close();
        }

    }
}







