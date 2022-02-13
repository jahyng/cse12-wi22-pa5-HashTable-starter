/**
 * TODO: Complete the solution for Sanctuary
 */
import java.util.HashMap;
import java.util.Set;

public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;

    public Sanctuary(int maxAnimals, int maxSpecies) {
        if (maxAnimals < 0 || maxSpecies < 0) {
            throw new IllegalArgumentException();
        }
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
    }

    public int getNum(String species) {
        if (species == null) {
            throw new IllegalArgumentException();
        }
        
    }
    
    public int getTotalAnimals() {
        return 0;
    }
    
    public int getTotalSpecies() {
        return 0;
    }

    public int rescue(String species, int num) {
        return 0;
    }

    public void release(String species, int num) {

    }
}
