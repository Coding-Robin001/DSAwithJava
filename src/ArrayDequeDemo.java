import java.util.ArrayDeque;

public class ArrayDequeDemo {
    public static void main(String[] args) {

        ArrayDeque<Integer> dq= new ArrayDeque<>();
        dq.offer(20);
        dq.offer(30);
        dq.offerFirst(97);
        dq.offerLast(45);
        dq.offer(44);
        System.out.println(dq);

        System.out.println(dq.pollFirst());
        System.out.println(dq.pollFirst());

        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());
    }
}
