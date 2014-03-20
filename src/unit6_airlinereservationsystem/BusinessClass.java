
package unit6_airlinereservationsystem;

/**
 *
 * @author John Mambo <john.mambo@gmail.com>
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import unit6_airlinereservationsystem.Aircraft.Column;


public class BusinessClass extends TravelClass {
    
    private final int capacity;
    private final int numOfRows;
    private final int numOfColumns;
    private final boolean isInitialized;
    private final List<List<Passenger>> passengerList = new ArrayList<>();
    
    public BusinessClass(int numOfRows, Column lastColumn) {
        this.numOfRows = numOfRows;
        this.numOfColumns = lastColumn.index();
        this.capacity = this.numOfRows * this.numOfColumns;
        /**
         * Lazy initialization follows - not thread safe
         */
        isInitialized = initialize(this.numOfRows, this.numOfColumns);
    }
    
    @Override
    public boolean placeResearvation(int rowNum, Column column, Passenger passenger) throws ClassCastException, IndexOutOfBoundsException, IllegalArgumentException, NullPointerException  {
        if (!isInitialized) {
            throw new NullPointerException("Passenger List has not been initialized");
        } 
        if (rowNum < 0 || rowNum > passengerList.size()) {
            throw new IndexOutOfBoundsException("The row# is out of bound");
        }
        if (column.index() < 0 || rowNum > passengerList.get(0).size()) {
            throw new IndexOutOfBoundsException("The column# is out of bound");
        }
        
        List<Passenger> _passenger =  passengerList.get(rowNum -1);
        
        if (_passenger.get(column.index() -1) == null) {
            _passenger.set(column.index() -1, passenger);
            return true;
        }else{
            throw new IllegalArgumentException("A passenger is already in the list");
        }
    }

    @Override
    public boolean cancelResearvation(int rowNum, Column column) throws NullPointerException {
        if (!isInitialized) {
            throw new NullPointerException("Passenger List has not been initialized");
        }
        if (rowNum < 0 || rowNum > passengerList.size()) {
            throw new IndexOutOfBoundsException("The row# is out of bound");
        }
        if (column.index() < 0 || rowNum > passengerList.get(0).size()) {
            throw new IndexOutOfBoundsException("The column# is out of bound");
        }
        
        List<Passenger> _passenger =  passengerList.get(rowNum -1);
        
        if (_passenger.get(column.index() -1) != null) {
            _passenger.set(column.index() -1, null);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean cancelResearvation(Passenger passenger) throws NullPointerException {
        if (!isInitialized) {
            throw new NullPointerException("Passenger List has not been initialized");
        }
        
        ListIterator<List<Passenger>> _rowIterator = passengerList.listIterator();
        while(_rowIterator.hasNext()){
             List<Passenger> _passengers =  _rowIterator.next();
             int i = 0;
             for (Passenger _passenger : _passengers) {
                if (passenger.equals(_passenger)) {
                _passengers.set(i, null);
                return true;
                }
                i++;
             }
        }
        return false;
    }

    @Override
    public boolean cancelAllResearvations() throws NullPointerException {
        if (!isInitialized) {
            throw new NullPointerException("Passenger List has not been initialized");
        }
        this.initialize(numOfRows, numOfColumns);
        return true;
    }

    @Override
    public Seat getResearvedSeat(Passenger passenger) {
        for (int i = 0; i < passengerList.size(); i++) {
            List<Passenger> _rowIteretor = passengerList.get(i);
            for (int j = 0; j < _rowIteretor.size(); j++) {
                Passenger _passenger = _rowIteretor.get(j);
                if (passenger.equals(_passenger)) {
                    Column c = Column.values()[j];
                    return new Seat(this, i+1, c);
                }
            }
        }
        return null;
    }

    @Override
    public Passenger getPassenger(Seat seat) throws UnsupportedOperationException, IndexOutOfBoundsException {   
        List<Passenger> _rowIterator = passengerList.get(seat.getSeatRow() - 1);
        return _rowIterator.get(seat.getSeatColumnIndex() - 1);
    }
    
    @Override
    public String toString() {
        return this.getClass().toString();
    }

    private boolean initialize(int numOfRows, int numOfColumns) {
        if (isInitialized) {
            Iterator<List<Passenger>> rowIterator = passengerList.iterator();
            while(rowIterator.hasNext()){
                List<Passenger> _passengers = rowIterator.next();
                for (int i = 0; i < _passengers.size(); i++) {
                _passengers.set(i, null);
                }
            }
        }else{
            /**
             * initialize the inner list
             */
            for (int i = 0; i < numOfRows; i++) {
                List<Passenger> _passengerList = new ArrayList<>(numOfColumns - 1 );
                for (int j = 0; j < numOfColumns; j++) {
                    _passengerList.add(null);
                }
                /**
                 * initialize the outer list
                 */
                passengerList.add(_passengerList);
            }
        }
        return true;
    }
}
