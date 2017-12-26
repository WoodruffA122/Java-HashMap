package videostore_woodruff;

import java.util.ArrayList;

/**
 *
 * @author arw5550
 */
public class Customer 
{
    private int customerID;
    private String firstName;
    private String lastName;
    private double accountBalance;
    private ArrayList<Movie> custMovies = new ArrayList();

    public Customer(int customerID, String firstName, String lastName, double accountBalance) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountBalance = accountBalance;
    }

    public Customer(int customerID) {   //seperate constructor to call in addRentals() in VideoStore
        this.customerID = customerID;
    }
    

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    
    public int getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.customerID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.customerID != other.customerID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerID + ", Name: " + firstName + " " + lastName + ", Balance: " + accountBalance;
    }

    
    
}
