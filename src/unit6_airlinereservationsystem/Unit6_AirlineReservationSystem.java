
package unit6_airlinereservationsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import unit6_airlinereservationsystem.Aircraft.Column;
import unit6_airlinereservationsystem.Aircraft.TypeOfTravelClass;

/**
 *
 * @author John Mambo <john.mambo@gmail.com>
 */
public class Unit6_AirlineReservationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final boolean DEBUG = true;
        
        if (DEBUG) {
            //Test code
        
            // FirstClass fc = new FirstClass(5, Column.F); // TODO: Enable when FirstClass is develped
            BusinessClass bc = new BusinessClass(3, Column.D);

            List<TravelClass> pList = new ArrayList();
            //tc.add(fc); // TODO: Enable when FirstClass is develped
            pList.add(bc);

            AircraftFactory cessna = new Aircraft();
            ConcurrentHashMap<TypeOfTravelClass, TravelClass> createdTravelClasses = cessna.createTravelClass(pList);

            FirstClass afc = (FirstClass) createdTravelClasses.get(TypeOfTravelClass.FIRSTCLASS);
            BusinessClass abc = (BusinessClass) createdTravelClasses.get(TypeOfTravelClass.BUSINESSCLASS);
            abc.placeResearvation(1,Column.B, new Passenger("Jack", "Frost"));
            abc.placeResearvation(1,Column.C, new Passenger("Jack", "Warm"));
            abc.placeResearvation(2,Column.C, new Passenger("Jim", "Frost"));
            abc.placeResearvation(2,Column.D, new Passenger("Jim", "Warm"));

            /* 
            TODO: Enable block when FirstClass is develped
            afc.placeResearvation(1,Column.A, new Passenger("Jane", "Frost"));
            afc.placeResearvation(2,Column.C, new Passenger("Jane", "Warm"));
            */

            Seat aResearvedSeat_1 = abc.getResearvedSeat(new Passenger("Jack", "Frost"));
            Seat aResearvedSeat_2 = abc.getResearvedSeat(new Passenger("Jack", "Warm"));
            abc.cancelResearvation(new Passenger("Jack", "frost"));
            Seat aResearvedSeat_3 = abc.getResearvedSeat(new Passenger("Jack", "Warm"));
            Passenger passenger = abc.getPassenger(aResearvedSeat_2);
              
        }
        
        // TODO: Place production code here

    }
    
}
