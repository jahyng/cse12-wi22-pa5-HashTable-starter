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
        this.sanctuary = new HashMap<String, Integer>(0);
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
    }

    public int getNum(String species) {
        if (species == null) {
            throw new IllegalArgumentException();
        }
        return this.sanctuary.get(species);
    }
    
    public int getTotalAnimals() {
        int total = 0;
        // for every species add getNum of speceis to total
        this.sanctuary.size(); // number of species
        // get set of keys
        Set <String> keys = this.sanctuary.keySet();
        // for each loop
        for (String key : keys) {
            total += this.getNum(key);
        }
        return total;
    }
    
    public int getTotalSpecies() {
        // get set of keys
        return this.sanctuary.size();
    }

    public int rescue(String species, int num) {
        if (num <= 0 || species == null) {
            throw new IllegalArgumentException();
        }
        if (this.getTotalAnimals() < this.maxAnimals && this.getTotalSpecies() < this.maxSpecies) {
            if (this.getTotalAnimals() + num > this.maxAnimals) {
                this.sanctuary.put(species, this.maxAnimals - this.getTotalAnimals());
                return num - (this.maxAnimals - this.getTotalAnimals());
            }
            this.sanctuary.put(species, num);
        }
        return 0;
    }

    public void release(String species, int num) {
        if (num <= 0 || num > this.getNum(species) || species == null || 
            this.getNum(species) == 0) {
            throw new IllegalArgumentException();
        }
        
        this.sanctuary.replace(species, this.getNum(species), 
            this.getNum(species) - num);
        if (this.getNum(species) == 0) {
            this.sanctuary.remove(species);
        }
    }
}
