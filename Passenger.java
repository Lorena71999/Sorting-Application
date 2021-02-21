
public class Passenger implements Comparable<Passenger> {
    String key;// f1 g1 s1 s2
    Double value; //e price ul ala calculat din hashmap

    Passenger(String key, Double value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public String toString() {
        return "Pasager{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }

    public int compareTo(Passenger x) {
        if (this.value < x.value)
            return -1;
        else if (this.value > x.value)
            return 1;
        else
            return 0;
    }
}
