/**
 * Thread to process booking requests
 */
public class BookingProcessor extends Thread{

    private BookingQueue queue;
    private RoomInventory inventory;

    public BookingProcessor(BookingQueue queue,RoomInventory inventory){
        this.queue=queue;
        this.inventory=inventory;
    }

    @Override
    public void run(){

        while(true){

            Reservation r;

            // synchronized queue access
            synchronized(queue){
                if(queue.isEmpty()) break;
                r=queue.getNext();
            }

            if(r!=null){

                // critical section (inventory update)
                boolean success=inventory.allocateRoom(r.getRoomType());

                if(success){
                    System.out.println(Thread.currentThread().getName()+
                            " booked "+r.getRoomType()+
                            " for "+r.getGuestName());
                }
                else{
                    System.out.println(Thread.currentThread().getName()+
                            " FAILED for "+r.getGuestName());
                }
            }
        }
    }
}