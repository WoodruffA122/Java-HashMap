package videostore_woodruff;

/**
 *
 * @author arw5550
 */
public class VideoStore_Woodruff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        VideoStore store = new VideoStore("Blockbuster");
        
        store.addMovie(new Movie("Birdman", 5));
        store.addMovie(new Movie("Frozen", 17));
        store.addMovie(new Movie("Home Again", 8));
        
        store.addCustomer(new Customer(123456, "Jon", "Batiste",0.00));
        store.addCustomer(new Customer(654321, "Harold", "Grimwall", 72.35));
        
        store.addRental(123456,"Birdman");
        store.addRental(123456, "Frozen");
        store.addRental(654321,"Birdman");
        //store.addRental(654321, "test");//Title not found
        //store.addRental(1, "Birdman");//customer not found
        
        store.showAll();
    }
    
}
