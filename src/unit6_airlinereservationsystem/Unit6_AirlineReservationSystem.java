
package unit6_airlinereservationsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import unit6_airlinereservationsystem.Aircraft.Column;
import unit6_airlinereservationsystem.Aircraft.TypeOfTravelClass;

//<editor-fold defaultstate="collapsed" desc="Group 1 Airline Reservation System Assignment">
/**
 * <pre>
 * III Graded Group Programming Exercise
 * 7.19 Airline Reservation System (50 points)
 * ----------------------------- TEXT BOOK -------------------------------------
 * 7.19 (Airline Reservations System) A small airline has just purchased a computer
 * for its new automated reservations system. You’ve been asked to develop the
 * new system. You’re to write an application to assign seats on each flight of
 * the airline’s only plane (capacity: 10 seats).
 * <br/>
 * Your application should display the following alternatives:
 * &nbsp Please type 1 for First Class and Please type 2 for Economy.
 * If the user types 1, your application should assign a seat in the first-class
 * section (seats 1–5).
 * If the user types 2, your application should assign a seat in the economy
 * section (seats 6–10). Your application should then display a boarding pass
 * indicating the person’s seat number and whether it’s in the first-class or
 * economy section of the plane.
 * <br/>
 * Use a one-dimensional array of primitive type boolean to represent the
 * seating chart of the plane. Initialize all the elements of the array to false
 * to indicate that all the seats are empty. As each seat is assigned, set the
 * corresponding element of the array to true to indicate that the seat is no
 * longer available.
 * <br/>
 * Your application should never assign a seat that has already been assigned.
 * When the economy section is full, your application should ask the person if
 * it’s acceptable to be placed in the first-class section (and vice versa).
 * If yes, make the appropriate seat assignment.
 * If no, display the message "Next flight leaves in 3 hours."
 * ---------------------------- END TEXT BOOK ----------------------------------
 *
 * Create a project that meets textbook requirements, as well as the following ones:
 * 1. Graphical user interface (GUI) should be functional, user-friendly and
 * &nbsp visually appealing. For this assignment, it is a requirement to use NetBeans
 * &nbsp Design option. Using only JOptionPane is not enough to earn a good grade.
 * 2. Use LayoutManager (nullLayout, BorderLayout, GridLayout, etc, not a FlowLayout)
 * &nbsp to create a nice GUI. A customer should be presented with a seat plan of
 * &nbsp the airplane for seat selection.
 * 3. Help and About should be reachable via the application Menu. Use JTabbedPane
 * &nbsp (see pages 1026 - 1027).
 * 4. Enhanced for loop should be used somewhere in the project.
 * 5. Create the following arrays:
 *  isTaken_FC //First class
 *  isTaken_EC // Economy class
 *  seatImages
 * 6. Each feature should be implemented as a method.
 * 7. Create and submit javadoc for your project.
 * <br/>
 * Extra points:
 *  Allow a customer to click on a seat on the diagram to select his seat,
 * &nbsp instead of requesting just the First of Economy class.
 *  Distinct sounds should accompany different actions and diagnostics.
 *  Add a class to have a customer to enter their name, to be added to the receipt.
 * <br/>
 * Workflow
 * Your group leader will initiate the conversation, and divide the project.
 * Alternatively, any group member could start the conversation by introducing
 * themselves and sharing their schedule in Group Discussion Forum.
 * After deciding on the algorithm and user interface, the group leader will
 * assign developing responsibilities among team members. For example:
 *
 *  Class UML
 *  GUI
 *  event handling
 *  images and sound
 *  javadoc
 *
 * Group leader will zip the project and upload the resulting file to the Group's dropbox by due date.
 * Every student will be graded according to his/her contribution to their group project.
 * Your design ideas and code should be posted to the Group Discussion.
 * Team leader will review the code.
 * <pre/>
 *
 *
 * @author John Mambo <john.mambo@gmail.com>
 */
//</editor-fold>
public class Unit6_AirlineReservationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final boolean DEBUG = false;
        
        if (DEBUG) {
            //Test code
        
            FirstClass fc = new FirstClass(5, Column.F);
            BusinessClass bc = new BusinessClass(3, Column.D);

            List<TravelClass> pList = new ArrayList();
            pList.add(fc);
            pList.add(bc);

            AircraftFactory cessna = new Aircraft();
            ConcurrentHashMap<TypeOfTravelClass, TravelClass> createdTravelClasses = cessna.createTravelClass(pList);

            FirstClass afc = (FirstClass) createdTravelClasses.get(TypeOfTravelClass.FIRSTCLASS);
            BusinessClass abc = (BusinessClass) createdTravelClasses.get(TypeOfTravelClass.BUSINESSCLASS);
            abc.placeResearvation(1,Column.B, new Passenger("Jack", "Frost"));
            abc.placeResearvation(1,Column.C, new Passenger("Jack", "Warm"));
            abc.placeResearvation(2,Column.C, new Passenger("Jim", "Frost"));
            abc.placeResearvation(2,Column.D, new Passenger("Jim", "Warm"));

            afc.placeResearvation(1,Column.A, new Passenger("Jane", "Frost"));
            afc.placeResearvation(2,Column.C, new Passenger("Jane", "Warm"));

            Seat aResearvedSeat_1 = abc.getResearvedSeat(new Passenger("Jack", "Frost"));
            Seat aResearvedSeat_2 = abc.getResearvedSeat(new Passenger("Jack", "Warm"));
            abc.cancelResearvation(new Passenger("Jack", "frost"));
            Seat aResearvedSeat_3 = abc.getResearvedSeat(new Passenger("Jack", "Warm"));
            Passenger passenger = abc.getPassenger(aResearvedSeat_2);
              
        }
        
        /**
         * Running the GUI
         */
        AirlineFrameGUI ui = null;
        try{
            ui = new AirlineFrameGUI();
        }
        catch(Exception ex){
            if(ui == null){
            } else {
                ui.dispose();
            }
        }
    }
    
}
