import java.io.Serializable;
import java.util.*;

public class RoomInventory implements Serializable{

    private static final long serialVersionUID=1L;

    private HashMap<String,Integer> map=new HashMap<>();

    public void addRoom(String type,int count){
        map.put(type,count);
    }

    public void allocate(String type){
        map.put(type,map.get(type)-1);
    }

    public HashMap<String,Integer> getData(){
        return map;
    }

    public void setData(HashMap<String,Integer> data){
        map=data;
    }

    public void show(){
        System.out.println("Inventory: "+map);
    }
}