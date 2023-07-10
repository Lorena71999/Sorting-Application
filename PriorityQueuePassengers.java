public class PriorityQueuePassengers<Passenger extends Comparable<Passenger>> {

    Passenger[] arr;
    int N;

    public PriorityQueuePassengers() {
        arr = (Passenger[]) new Comparable[2];
        N = 0;
    }

    public void insert(Passenger t) {
        if (N == arr.length - 1) resize(2 * N + 1);
        arr[++N] = t;
        swim(N);
    }

    public Passenger embark() {
        if (isEmpty()) return null;
        Passenger t = arr[1];
        exch(1, N--);
        arr[N + 1] = null;
        sink(1);

        if (N == (arr.length - 1) / 4) resize((arr.length - 1) / 2 + 1);
        return t;
    }

    public String list() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++)
            sb.append(arr[i].toString()).append(" ");
        sb.append("\n");
        return sb.toString();

    }

    private boolean isEmpty() {
        return N == 0;
    }

    private void resize(int capacity) {
        Passenger[] copy = (Passenger[]) new Comparable[capacity];

        if (N >= 0) System.arraycopy(arr, 1, copy, 1, N);
        arr = copy;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k < N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j = j + 1;
            if (less(j, k)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private void exch(int i, int j) {
        Passenger temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

















