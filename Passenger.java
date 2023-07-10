package model;

public class Passenger implements Comparable<Passenger>{

    private String key;
    private Double value;

    public Passenger(String key, Double value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Pasager{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Passenger x) {
        if (this.value < x.value)
            return -1;
        else if (this.value > x.value)
            return 1;
        else
            return 0;
    }
}
