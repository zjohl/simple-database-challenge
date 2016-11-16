package turo.codeexercise.model;

/**
 * Created by Zamir on 2016-11-14.
 */
public interface IDatabaseModel {

    /**
     * Adds an entry to the database with the given name and value
     *
     * @param name the name of the entry to add
     * @param value the value of the entry
     * @return the previous value of the entry
     */
    String addEntry(String name, String value);

    /**
     * Removes an entry to the database with the given name
     *
     * @param name the name of the entry to remove
     * @return the value previously contained in that entry
     */
    String removeEntry(String name);

    /**
     * Returns the value of the specified entry
     *
     * @param name the name of the entry to retrieve
     * @return the value of the entry or null
     */
    String getEntry(String name);

    /**
     * Returns the number of entries containing the specified value
     *
     * @param value the value of the entry to search for
     * @return integer representing number of times the value is in the database
     */
    int numValue(String value);
}
