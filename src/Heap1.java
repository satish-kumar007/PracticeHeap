import java.util.PriorityQueue;

public class Heap1 {
    public static void main(String[] args) {
        System.out.println("Heap");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(20);
        pq.add(50);
        pq.add(70);
        pq.add(90);
        pq.add(10);
        pq.add(30);
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);
    }
}
