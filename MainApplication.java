import model.Passenger;
import model.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApplication {

    private static final String FILE_NAME = "queue_in.txt";
    private static final String QUEUE_OUT_TXT = "queue_out.txt";
    private static final String INSERT = "insert";
    private static final String EMBARK = "embark";
    private static final String LIST = "list";

    public static void main(String[] args) throws IOException {

        List<Person> people = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;

        int totalPersons = Integer.parseInt(String.valueOf(br.readLine().charAt(0)));
        getPersonsList(people, br, totalPersons);

        Map<String, Double> getScorePerPerson = new HashMap<>();
        for (Person person : people) {
            String id = person.getId();
            double score = getScorePerPerson.containsKey(id) ? getScorePerPerson.get(id) : 0;
            score += new FinalScoreGeneratorImpl().getFinalScore(person);
            getScorePerPerson.put(id, score);
        }

        for (String id : getScorePerPerson.keySet()) {
            if (id.startsWith("f")) {
                getScorePerPerson.replace(id, getScorePerPerson.get(id) + 10);
            }
            if (id.startsWith("g")) {
                getScorePerPerson.replace(id, getScorePerPerson.get(id) + 5);
            }
        }

        PriorityQueuePassengers<Passenger> pr = new PriorityQueuePassengers<>();
        ArrayList<String> command = new ArrayList<>();
        int j = totalPersons;

        while ((line = br.readLine()) != null) {
            command.add(line);
            j++;
        }

        try {
            FileWriter myWriter = new FileWriter(QUEUE_OUT_TXT);
            performCommands(getScorePerPerson, pr, command, myWriter);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    private static void performCommands(Map<String, Double> getScorePerPerson,
                                        PriorityQueuePassengers<Passenger> pr, ArrayList<String> command,
                                        FileWriter myWriter) throws IOException {

        for (String s : command) {
            if (s.contains(INSERT)) {
                String[] idFromCommand = s.split(" ");

                if (getScorePerPerson.get(idFromCommand[1]) == 0) {
                    pr.insert(new Passenger(idFromCommand[1], 0.0));
                }
                pr.insert(new Passenger(idFromCommand[1], getScorePerPerson.get(idFromCommand[1])));
            }

            if (s.equalsIgnoreCase(EMBARK)) {
                pr.embark();
            }

            if (s.equalsIgnoreCase(LIST)) {
                myWriter.flush();
                myWriter.write(pr.list());
                System.out.println(pr.list());
            }
        }
    }

    private static void getPersonsList(List<Person> people, BufferedReader br, int n) throws IOException {
        String line;
        int i = 0;
        ArrayList<String> vector = new ArrayList<>();

        while ((line = br.readLine()) != null && i < n) {
            i++;
            vector.add(line);
        }

        for (int k = 0; k < n; k++) {
            String[] s = vector.get(k).split(" ");
            String id = s[0];
            String name = s[1];
            int age = Integer.parseInt(s[2]);
            String ticketType = s[3];
            boolean priority = Boolean.parseBoolean(s[4]);
            boolean specialNeed = Boolean.parseBoolean(s[5]);
            people.add(new Person(id, name, age, ticketType, priority, specialNeed));
        }
    }
}







