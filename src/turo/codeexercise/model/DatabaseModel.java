package turo.codeexercise.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zamir on 2016-11-14.
 */
public class DatabaseModel implements IDatabaseModel {

    private Map<String, String> entries = new HashMap<String, String>();
    private Map<String, Integer> counts = new HashMap<String, Integer>();

    /**
     * Adds an entry to the database with the given name and value
     *
     * @param name the name of the entry to add
     * @param value the value of the entry
     */
    public String addEntry(String name, String value) {
        String prevValue = "";
        if(this.entries.containsKey(name)) {
            prevValue = this.entries.get(name);
            this.reduceCount(prevValue);
        }
        this.entries.put(name, value);
        this.addCount(value);
        return prevValue;
    }

    /**
     * Removes an entry to the database with the given name
     *
     * @param name the name of the entry to remove
     * @return the value previously contained in that entry
     */
    public String removeEntry(String name) {
        String prevValue = this.entries.remove(name);
        this.reduceCount(prevValue);
        return prevValue;
    }

    /**
     * Creates an entry in the countMap for the value
     * If entry already exists it is incremented
     *
     * @param value key of count map value to increase
     */
    private void addCount(String value) {
        if(counts.containsKey(value)) {
            this.counts.put(value, 1 + this.counts.get(value));
        } else {
            this.counts.put(value, 1);
        }
    }

    /**
     * Decrements the number of occurances of a value in the database
     * If value has only one count it is removed
     *
     * @param value key of count map value to decrease
     */
    private void reduceCount(String value) {
        if(this.counts.containsKey(value) && this.counts.get(value) > 1) {
            this.counts.put(value, this.counts.get(value) - 1);
        } else {
            this.counts.remove(value);
        }
    }

    /**
     * Returns the value of the specified entry
     *
     * @param name the name of the entry to retrieve
     * @return the value of the entry or null
     */
    public String getEntry(String name) {
        return this.entries.get(name);
    }

    /**
     * Returns the number of entries containing the specified value
     *
     * @param value the value of the entry to search for
     * @return integer representing number of times the value is in the database
     */
    public int numValue(String value) {
        if(this.counts.containsKey(value)) {
            return this.counts.get(value);
        }
        else {
            return 0;
        }
    }
}
