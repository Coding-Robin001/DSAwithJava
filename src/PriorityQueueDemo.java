import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {

        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        q.offer(20);
        q.offer(30);
        q.offer(22);
        q.offer(44);
        q.offer(98);

        System.out.println(q.peek());
        q.poll();

        System.out.println(q.peek());

    }
}
