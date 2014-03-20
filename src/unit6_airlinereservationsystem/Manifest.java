
package unit6_airlinereservationsystem;

import java.util.Objects;

/**
 *
 * @author John Mambo <john.mambo@gmail.com>
 */
public abstract class Manifest implements Comparable<Manifest> {
    String firstName;
    String lastName;
    
        
    public abstract boolean placeResearvation();
    public abstract boolean cancelResearvation();
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        
        return (this.firstName == null ? ((Manifest)obj).firstName == null : this.firstName.toLowerCase().equals(((Manifest)obj).firstName.toLowerCase())) && (this.lastName == null ? ((Manifest)obj).lastName == null : this.lastName.toLowerCase().equals(((Manifest)obj).lastName.toLowerCase())); 
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.firstName);
        hash = 11 * hash + Objects.hashCode(this.lastName);
        return hash;
    }

    @Override
    public int compareTo(Manifest manifest) {
        if (this.equals(manifest)) {
            return 0;
        }
        
        return this.lastName.compareToIgnoreCase(manifest.lastName) == 0 ? this.firstName.compareToIgnoreCase(manifest.firstName) : this.lastName.compareToIgnoreCase(manifest.lastName);
    }
}
