import java.util.*;

public class BookingQueue{

    private Queue<Reservation> queue=new LinkedList<>();

    public void addRequest(Reservation r){
        queue.add(r);
    }

    public Reservation getNext(){
        return queue.poll(); // FIFO
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}