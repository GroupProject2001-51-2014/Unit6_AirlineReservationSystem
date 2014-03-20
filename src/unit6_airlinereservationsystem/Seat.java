
package unit6_airlinereservationsystem;

import unit6_airlinereservationsystem.Aircraft.Column;

/**
 *
 * @author John Mambo <john.mambo@gmail.com>
 */
public class Seat {
    private final TravelClass seatClass;
    private final int row;
    private final Column column;
    
    public Seat(TravelClass seatClass, int row, Aircraft.Column column){
        this.seatClass = seatClass;
        this.row = row;
        this.column = column;
    }
    
    public Seat getSeat(){
        return this;
    }
    
    public TravelClass getSeatClass(){
        return this.seatClass;
    }
    
    public int getSeatRow(){
        return this.row;
    }
    
    public Column getSeatColumn(){
        return this.column;
    }
    
    public int getSeatColumnIndex(){
        return this.column.index();
    }
}
