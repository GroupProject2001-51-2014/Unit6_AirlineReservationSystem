
package unit6_airlinereservationsystem;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author John Mambo <john.mambo@gmail.com>
 */
public class Aircraft extends AircraftFactory {
    private final ConcurrentHashMap<TypeOfTravelClass, TravelClass> travelClasses = new ConcurrentHashMap(5, 0.9f, 2);
    private boolean isInitialized;
 
    public enum TypeOfAircraft{
        LIGHT(1),
        MIDSIZE(2), 
        LARGE(3);
        
        private final int val;

        private TypeOfAircraft(int val){
            this.val = val;
        }
        
        /**
         * This method returns the Ordinal position of the Level enumerable value property.
         * @return {@code int} Corresponding ordinal position of the Level enumerable property. 
         */
        public int index(){
            return val;
        }
    }
    
    public enum TypeOfTravelClass{
        FIRSTCLASS(1),
        BUSINESSCLASS(2),
        ECONOMYCLASS(3);
        
        private final int val;

        private TypeOfTravelClass(int val){
            this.val = val;
        }
        
        /**
         * This method returns the Ordinal position of the Level enumerable value property.
         * @return {@code int} Corresponding ordinal position of the Level enumerable property. 
         */
        public int index(){
            return val;
        }
    }
    
    public enum Column{
        A(1),
        B(2),
        C(3),
        D(4),
        E(5),
        F(6),
        G(7),
        H(8),
        I(9),
        J(10);
        
        private final int val;

        private Column(int val){
            this.val = val;
        }
        
        /**
         * This method returns the Ordinal position of the Level enumerable value property.
         * @return {@code int} Corresponding ordinal position of the Level enumerable property. 
         */
        public int index(){
            return val;
        }
    }
    
//<editor-fold defaultstate="collapsed" desc="REMOVE">
    /*
    public boolean creatTravelClass(TravelClass travelClass){
    String _classFQN = travelClass.getClass().getName();
    int _qualifier = _classFQN.indexOf(".");
    String _class = _classFQN.substring(_qualifier + 1);
    
    switch(_class){
    case "FirstClass": this.travelClasses.put(TypeOfTravelClass.FIRSTCLASS, travelClass);
    return true;
    case "BusinessClass": this.travelClasses.put(TypeOfTravelClass.BUSINESSCLASS, travelClass);
    return true;
    case "EconomyClass": this.travelClasses.put(TypeOfTravelClass.ECONOMYCLASS, travelClass);
    return true;
    default:
    throw new IllegalArgumentException("Not a Type of Travel Class");
    }
    }
    */
//</editor-fold>
    
    private boolean initialize(ConcurrentHashMap<TypeOfTravelClass, TravelClass> _travelClasses) throws UnsupportedOperationException {
        this.travelClasses.putAll(_travelClasses);
        return true;
    }
 
    @Override
    public ConcurrentHashMap<TypeOfTravelClass, TravelClass> createTravelClass(List<TravelClass> travelClasses) throws UnsupportedOperationException {
        ConcurrentHashMap<TypeOfTravelClass, TravelClass> _travelClasses = new ConcurrentHashMap(5, 0.9f, 2);
        
        for(TravelClass _travelClass : travelClasses){
            String _travelClassFQN = _travelClass.getClass().getName();
            String _travelClassName = _travelClassFQN.substring(_travelClassFQN.indexOf(".") +1);
            switch(_travelClassName){
                case "FirstClass":      _travelClasses.put(TypeOfTravelClass.FIRSTCLASS, _travelClass);
                    break;
                case "BusinessClass":   _travelClasses.put(TypeOfTravelClass.BUSINESSCLASS, _travelClass);
                    break;
                case "EconomyClass": this.travelClasses.put(TypeOfTravelClass.ECONOMYCLASS, _travelClass);
                    break;
                default:    
                    throw new IllegalArgumentException("Type of Travel class not valid");
            }
        }
        isInitialized = this.initialize(_travelClasses);
        return _travelClasses;
    }

    @Override
    public ITravelClassIterator createIterator() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
    //<editor-fold defaultstate="collapsed" desc="REMOVE">
    /*
    public boolean createFirstClass(int rows, Column lastColumn){
        if (rows > 0 && lastColumn != null) {
            this.firstClass = new FirstClass(rows, lastColumn);
            return true;
        }
        return false;
    }
    
    public boolean createBusinessClass(int rows, Column lastColumn){
        if (rows > 0 && lastColumn != null) {
            this.businessClass = new BusinessClass(rows, lastColumn);
            return true;
        }
        return false;
    }
    
    public boolean createEconomyClass(int rows, Column lastColumn){
        if (rows > 0 && lastColumn != null) {
            this.economyClass = new EconomyClass(rows, lastColumn);
            return true;
        }
        return false;
    }
    */    
    
//</editor-fold>

    
//<editor-fold defaultstate="collapsed" desc="REMOVE">
    /*
    public AircraftFactory createAircraft(TypeOfAircraft typeOfAircraft) throws AssertionError{
        switch(typeOfAircraft){
            case LIGHT:     return new LightAircraft();
            case MIDSIZE:   return new MidsizeAircraft();
            case LARGE:     return new LargeAircraft();
            default:
                throw new AssertionError(typeOfAircraft.name());
        }
    }
    */
//</editor-fold>
}
