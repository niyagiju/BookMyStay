import java.io.*;

/**
 * Handles save & recovery
 */
public class PersistenceService{

    private static final String FILE_NAME="system_state.dat";

    // SAVE
    public static void save(SystemState state){

        try(ObjectOutputStream out=
                    new ObjectOutputStream(new FileOutputStream(FILE_NAME))){

            out.writeObject(state);
            System.out.println("System state saved successfully!");

        }catch(Exception e){
            System.out.println("Error saving data: "+e.getMessage());
        }
    }

    // LOAD
    public static SystemState load(){

        try(ObjectInputStream in=
                    new ObjectInputStream(new FileInputStream(FILE_NAME))){

            System.out.println("System state loaded successfully!");
            return (SystemState)in.readObject();

        }catch(FileNotFoundException e){
            System.out.println("No saved data found. Starting fresh.");
        }catch(Exception e){
            System.out.println("Error loading data. Starting fresh.");
        }

        return null;
    }
}