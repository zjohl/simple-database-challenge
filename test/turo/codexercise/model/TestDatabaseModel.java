package turo.codexercise.model;

import org.junit.*;
import turo.codeexercise.model.DatabaseModel;

import static org.junit.Assert.*;

public class TestDatabaseModel {
    public DatabaseModel database;

    @Before
    public void setUp() {
        database = new DatabaseModel();
        database.addEntry("a", "1");
        database.addEntry("b", "2");
        database.addEntry("c", "3");
        database.addEntry("d", "2");
    }

    @Test
    // tests that entries can be retrieved from database
    public void getsEntries() {
        assertEquals("1", database.getEntry("a"));
        assertEquals("2", database.getEntry("b"));
        assertEquals("2", database.getEntry("d"));
        assertEquals("1", database.getEntry("a"));
    }

    @Test
    // tests that entries can be removed from database
    public void removesEntries() {
        assertEquals("1", database.getEntry("a"));
        database.removeEntry("a");
        assertEquals(null, database.getEntry("a"));
        database.addEntry("a", "1");
        assertEquals("1", database.getEntry("a"));
    }

    @Test
    // tests that the number of occurrences of a value can be retrieved
    public void getsNumOccurances() {
        assertEquals(0, database.numValue("0"));
        assertEquals(1, database.numValue("1"));
        assertEquals(2, database.numValue("2"));
        assertEquals(1, database.numValue("3"));
    }

    @Test
    // tests that previous values are correctly returned when setting or removing entries
    public void returnsPreviousValue() {
        assertEquals("1", database.addEntry("a", "2"));
        assertEquals("2", database.removeEntry("a"));
        assertEquals("", database.addEntry("a", "3"));
        assertEquals("3", database.removeEntry("a"));
    }

}