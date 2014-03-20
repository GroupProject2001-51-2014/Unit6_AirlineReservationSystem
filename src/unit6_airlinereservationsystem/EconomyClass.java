
package unit6_airlinereservationsystem;

import unit6_airlinereservationsystem.Aircraft.Column;

public class EconomyClass extends TravelClass{

    EconomyClass(int rows, Column lastColumn) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean placeResearvation(int rowNum, Column column, Passenger passenger) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean cancelResearvation(int rowNum, Column column) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean cancelResearvation(Passenger passenger) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean cancelAllResearvations() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Seat getResearvedSeat(Passenger passenger) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Passenger getPassenger(Seat seat) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
}
