package videostore_woodruff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
//import java.util.ListIterator;

/**
 *
 * @author arw5550
 */
public class VideoStore 
{
    private Movie tempMovie = null;
    private Customer tempCustomer = null;
    private String storeName;
    private HashSet<Movie> movies = new HashSet();
    private HashSet<Customer> customers = new HashSet();
    private ArrayList<Movie> list = new ArrayList();
    private HashMap<Customer, ArrayList<Movie>> customerRentals = new HashMap();

    
    public VideoStore(String storeName) {
        this.storeName = storeName;
    }
    
    public boolean addMovie(Movie movie)
    {
        return movies.add(movie); 
    }
    
    public boolean addCustomer(Customer customer)
    {
        return customers.add(customer);
    }
    
    public boolean addRental(int customerID, String title)
    {
        Movie searchMovie = new Movie(title);
        Customer searchCustomer = new Customer(customerID);
        
        if(movies.contains(searchMovie))
        {
            Iterator movieItr = movies.iterator();
        
            while (movieItr.hasNext())
            {
                Movie x = (Movie)movieItr.next();
                if(x.equals(searchMovie) && x.getNumCopies() > 0)
                {
                    tempMovie = x;
                    list.add(tempMovie);
                }
            }
        }
        else
        {
            System.out.println("Title not found, or not enough copies");
            return false;
        }
        
        if(customers.contains(searchCustomer))
        {
        
            Iterator custItr = customers.iterator();

            while (custItr.hasNext())
            {
                Customer y = (Customer)custItr.next();
                if(y.getCustomerID() == customerID)
                {
                    tempCustomer = y;
                }
            }
            
            if (customerRentals.containsKey(tempCustomer))          //this section (lines 77-83) does NOT properly add the movie objects
            {                                                       //to the ArrayList<Movie> value in customerRental. This is possibly
                ArrayList<Movie> tempList = new ArrayList();        //due to the fact that I am approaching this problem from a different
                tempList = customerRentals.get(tempCustomer);       //point of view than discussed in class on 10/23. Regardless, what this
                tempMovie.decrement();                              //currently does is adds all Movie objects from the addMovie() method in
                customerRentals.replace(tempCustomer, tempList);    //main to one single ArrayList<Movie> called list and decrement the numCopies.
            }
            
            else
            {
            customerRentals.put(tempCustomer, list);
            tempMovie.decrement();
            }
        }
        
        else
            System.out.println("Customer not found.");
        
        return true;
    }
    
    public void showAll()
    {
        System.out.println("Movies: ");
        
        for(Movie m : movies)
            System.out.println(m);
        
        System.out.println();
        
        System.out.println("Customers: ");
        for(Customer c : customers)
            
            System.out.println(c);
        
        System.out.println();
        System.out.println("Map: ");
        for (HashMap.Entry<Customer, ArrayList<Movie>> entry : customerRentals.entrySet())
            System.out.println(entry);
    }
    
}
