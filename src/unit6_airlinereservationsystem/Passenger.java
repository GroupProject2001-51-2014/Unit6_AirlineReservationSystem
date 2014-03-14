
package unit6_airlinereservationsystem;

/**
 *
 * @author John Mambo <john.mambo@gmail.com>
 */

public class Passenger extends Manifest {

    public Passenger(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    @Override
    public boolean placeResearvation() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean cancelResearvation() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
