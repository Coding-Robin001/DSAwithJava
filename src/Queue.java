

public class Queue {

    int queue[] = new int[5];
    int size = 0;
    int front = 0;
    int rear = 0;

    public void enQueue(int data){
        if (!isFull()){
            queue[rear] = data;
            rear = (rear+1)%5;
            size++;
        } else
            System.out.println("Queue is full!");
    }

    public int deQueue(){

        int data = queue[front];
        if (!isEmpty()) {
            front = (front + 1) % 5;
            size--;
        } else
            System.out.println("Queue is Empty!");
        return data;
    }

    public void show(){
        for (int i =0; i<size; i++){
            System.out.print(queue[(front + i)%5] + " ");
        }
    }

    public  int getSize(){
        return size;
    }

    public boolean isFull(){
        return getSize() == 5;
    }

    public boolean isEmpty (){
        return  getSize() == 0;
    }
}
