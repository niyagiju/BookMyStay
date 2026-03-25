import java.io.Serializable;
import java.util.*;

public class BookingHistory implements Serializable{

    private static final long serialVersionUID=1L;

    private List<Reservation> list=new ArrayList<>();

    public void add(Reservation r){
        list.add(r);
    }

    public List<Reservation> getAll(){
        return list;
    }

    public void show(){
        for(Reservation r:list){
            System.out.println(r);
        }
    }
}