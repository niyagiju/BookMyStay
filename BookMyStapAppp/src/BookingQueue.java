import java.util.*;

public class BookingQueue{

    private Queue<Reservation> queue=new LinkedList<>();

    // synchronized → thread-safe access
    public synchronized void addRequest(Reservation r){
        queue.add(r);
    }

    public synchronized Reservation getNext(){
        return queue.poll();
    }

    public synchronized boolean isEmpty(){
        return queue.isEmpty();
    }
}