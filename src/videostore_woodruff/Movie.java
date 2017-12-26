package videostore_woodruff;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author arw5550
 */
public class Movie 
{
    private String movieTitle;
    private int numCopies;

    public Movie(String movieTitle, int numCopies) {
        this.movieTitle = movieTitle;
        this.numCopies = numCopies;
    }

    public Movie(String movieTitle) {   //seperate constructor to call in addRentals() in 
        this.movieTitle = movieTitle;
    }
    

    
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    
    public String getMovieTitle() {
        return movieTitle;
    }

    public int getNumCopies() {
        return numCopies;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.movieTitle);
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
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.movieTitle, other.movieTitle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return movieTitle + ", " + numCopies;
    }
    
    public void decrement()
    {
        numCopies--;
        //System.out.println(numCopies);
    }
    
    
}
