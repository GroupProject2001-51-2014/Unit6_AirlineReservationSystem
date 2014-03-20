
package unit6_airlinereservationsystem;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import unit6_airlinereservationsystem.Aircraft.TypeOfTravelClass;

/**
 *
 * @author John Mambo <john.mambo@gmail.com>
 */
public abstract class AircraftFactory implements ISeatClassAggregate {
    public abstract ConcurrentHashMap<TypeOfTravelClass, TravelClass> createTravelClass(List<TravelClass> travelClasses) throws UnsupportedOperationException;
}
