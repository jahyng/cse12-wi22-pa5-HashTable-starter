/**
 * Josh Yang
 * A16667394
 * jwyang@ucsd.edu
 * I used the java site for hashmap implementation given in the PA writeup. 
 */
import java.util.HashMap;
import java.util.Set;

/**
 * This class creates sanctuary for animals. There are three instance variables: 
 * ints maxAnimals and maxSpecies, and HashMap sanctuary. 
 */
public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;

    /**
     * constructor for santuary
     * @param maxAnimals maximum capacity of animals
     * @param maxSpecies maximum number of species allowed
     */
    public Sanctuary(int maxAnimals, int maxSpecies) {
        if (maxAnimals < 0 || maxSpecies < 0) {
            throw new IllegalArgumentException();
        }
        this.sanctuary = new HashMap<String, Integer>(0);
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
    }

    /**
     * gets number of animals of specified species
     * @param species species that will be counted
     * @return number of animals of given species
     */
    public int getNum(String species) {
        if (species == null) {
            throw new IllegalArgumentException();
        }
        return this.sanctuary.get(species);
    }
    /**
     * gets total number of animals in sanctuary
     * @return total number of animals in sanctuary 
     */
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
    
    /**
     * gets total number of species in sanctuary
     * @return total number of species in sanctuary
     */
    public int getTotalSpecies() {
        // get set of keys
        return this.sanctuary.size();
    }

    /**
     * adds specified number of species to sacntuary if situation allows. Has 
     * instance variable emptySpots which gives the amount of space left for 
     * animals to move in
     * @param species the speceis of animal to add
     * @param num number of animals to add
     * @return number of animals that could not be admitted
     */
    public int rescue(String species, int num) {
        if (num <= 0 || species == null) {
            throw new IllegalArgumentException();
        }

        // instance var to help 
        int emptySpots = this.maxAnimals - this.getTotalAnimals();
        // adding species that's already there
        if (this.sanctuary.containsKey(species)) {
            if (this.getTotalAnimals()  + num <= this.maxAnimals) {
                this.sanctuary.replace(species, 
                    this.sanctuary.get(species) + num);
                return 0;
            }
            else {
                this.sanctuary.replace(species, 
                    this.sanctuary.get(species) + emptySpots);
                return num - emptySpots;
            }
        }

        // adding new species
        else if (this.getTotalAnimals() < this.maxAnimals && 
            this.getTotalSpecies() < this.maxSpecies) {
            if (this.getTotalAnimals() + num > this.maxAnimals) {
                this.sanctuary.put(species, emptySpots);
                return num - emptySpots;
            }
            this.sanctuary.put(species, num);
            return 0;
        } else return 0;
    }

    /**
     * releases specified number of animals of species. If the entire species is 
     * released, remove species from santuary.
     * @param species species that will be released
     * @param num number of animals to be released
     */
    public void release(String species, int num) {
        if (!this.sanctuary.containsKey(species) || num <= 0 || 
            num > this.getNum(species) || species == null) {
            throw new IllegalArgumentException();
        }

        if (this.getTotalAnimals() == 0) {
            throw new IllegalArgumentException();
        }
        
        this.sanctuary.replace(species, this.getNum(species), 
            this.getNum(species) - num);

        // remove species if no more animals
        if (this.getNum(species) == 0) {
            this.sanctuary.remove(species);
        }
    }
}
