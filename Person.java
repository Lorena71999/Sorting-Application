package model;

public class Person {

    private final String id;
    private final String name;
    private final int age;
    private final String ticketType;
    private final boolean priority;
    private final boolean specialNeed;

    public Person(String id, String name, int age, String ticketType, boolean priority, boolean specialNeed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ticketType = ticketType;
        this.priority = priority;
        this.specialNeed = specialNeed;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean getPriority() {
        return priority;
    }

    public boolean getSpecialNeed() {
        return specialNeed;
    }

    public String getTicketType() {
        return ticketType;
    }

    @Override
    public String toString() {
        return "model.Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ticketType='" + ticketType + '\'' +
                ", priority=" + priority +
                ", specialNeed=" + specialNeed +
                '}';
    }
}