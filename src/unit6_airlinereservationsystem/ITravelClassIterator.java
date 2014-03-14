
package unit6_airlinereservationsystem;

/**
 *
 * @author John Mambo <john.mambo@gmail.com>
 */
public interface ITravelClassIterator {
    
    public TravelClass first() throws UnsupportedOperationException;

    public TravelClass next() throws UnsupportedOperationException;

    public TravelClass currentSeat() throws UnsupportedOperationException;

    public TravelClass previous() throws UnsupportedOperationException;

    public TravelClass last() throws UnsupportedOperationException;

    public boolean hasNext() throws UnsupportedOperationException;

    public boolean isEmpty() throws UnsupportedOperationException;
    
    public boolean isFull() throws UnsupportedOperationException;
}
