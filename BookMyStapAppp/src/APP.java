public class APP {

    public static void main(String[] args){

        System.out.println("===== Hotel Room Availability =====");

        // Static availability variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Polymorphism
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        r1.displayDetails();
        System.out.println("Available: "+singleAvailable);
        System.out.println();

        r2.displayDetails();
        System.out.println("Available: "+doubleAvailable);
        System.out.println();

        r3.displayDetails();
        System.out.println("Available: "+suiteAvailable);
        System.out.println();
    }
}