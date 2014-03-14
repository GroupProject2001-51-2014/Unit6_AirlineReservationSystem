
package unit6_airlinereservationsystem;

/**
 *
 * @author John Mambo <john.mambo@gmail.com>
 */
public interface ISeatClassAggregate {
    public ITravelClassIterator createIterator() throws UnsupportedOperationException;
}
