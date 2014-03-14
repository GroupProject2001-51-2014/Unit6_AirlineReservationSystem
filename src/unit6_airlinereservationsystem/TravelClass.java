
package unit6_airlinereservationsystem;

import unit6_airlinereservationsystem.Aircraft.Column;

/**
 *
 * @author John Mambo <john.mambo@gmail.com>
 */
public abstract class TravelClass {
    public abstract boolean placeResearvation(int rowNum, Column column, Passenger passenger) throws UnsupportedOperationException;
    public abstract boolean cancelResearvation(int rowNum, Column column) throws UnsupportedOperationException;
    public abstract boolean cancelResearvation(Passenger passenger) throws UnsupportedOperationException;
    public abstract boolean cancelAllResearvations() throws UnsupportedOperationException;
    public abstract Seat getResearvedSeat(Passenger passenger) throws UnsupportedOperationException;
    public abstract Passenger getPassenger(Seat seat) throws UnsupportedOperationException;
}