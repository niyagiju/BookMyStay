/**
 * Hotel Booking System
 * Use Case 2: Basic Room Types & Static Availability
 * Demonstrates abstraction, inheritance, polymorphism and static availability.
 *
 * @author ni
 * @version 1.0
 */

abstract class Room{
    protected String type;
    protected int beds;
    protected int size;
    protected double price;

    public Room(String type,int beds,int size,double price){
        this.type=type;
        this.beds=beds;
        this.size=size;
        this.price=price;
    }

    public void displayDetails(){
        System.out.println("Room Type: "+type);
        System.out.println("Beds: "+beds);
        System.out.println("Size: "+size+" sq ft");
        System.out.println("Price: $"+price);
    }
}

class SingleRoom extends Room{
    public SingleRoom(){
        super("Single Room",1,200,100);
    }
}

class DoubleRoom extends Room{
    public DoubleRoom(){
        super("Double Room",2,350,180);
    }
}

class SuiteRoom extends Room{
    public SuiteRoom(){
        super("Suite Room",3,500,300);
    }
}

public class APP{

    public static void main(String[] args){

        System.out.println("===== Hotel Room Availability =====");

        int singleAvailable=5;
        int doubleAvailable=3;
        int suiteAvailable=2;

        Room r1=new SingleRoom();
        Room r2=new DoubleRoom();
        Room r3=new SuiteRoom();

        r1.displayDetails();
        System.out.println("Available: "+singleAvailable);
        System.out.println();

        r2.displayDetails();
        System.out.println("Available: "+doubleAvailable);
        System.out.println();

        r3.displayDetails();
        System.out.println("Available: "+suiteAvailable);
    }
}