package p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseCtorMoreThan16ElementsTrows() throws OperationNotSupportedException{ //constructor
        Integer[] largerArray = new Integer[16 + 1];
        Database database = new Database(largerArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseCtorLessThan1ElementsTrows() throws OperationNotSupportedException { //constructor
        Integer[] largerArray = new Integer[0];
        Database database = new Database(largerArray);
    }

    @Test
    public void testDatabaseCtorInitializes16Capacity() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException { //constructor
        Database database = new Database(10, 11, 12, 13, 14);

        Field elementsField = Database.class.getDeclaredField("elements");
        elementsField.setAccessible(true);
        Integer[] elements = (Integer[]) elementsField.get(database);
        assertEquals(16, elements.length);
    }

    @Test
    public void testDatabaseCtor() throws OperationNotSupportedException {
        Integer[] expectedElements = {10, 11, 12, 13, 14};

        Database database = new Database(expectedElements);

        Integer[] actualElements = database.getElements();
        assertEquals(expectedElements.length, actualElements.length);
        assertEquals(expectedElements[0], actualElements[0]);
        assertEquals(expectedElements[1], actualElements[1]);
        assertEquals(expectedElements[2], actualElements[2]);
        assertEquals(expectedElements[3], actualElements[3]);
        assertEquals(expectedElements[4], actualElements[4]);
    }

    @Test
    public void testAdd() throws OperationNotSupportedException {
        Integer[] initialElements = {10, 11, 12, 13, 14};
        Database database = new Database(initialElements);

        database.add(15);

        Integer[] actualElements = database.getElements();
        assertEquals(initialElements.length + 1, actualElements.length);
    }

    @Test
    public void testRemove() {
        //TODO
    }

    @Test
    public void testGetElement() {
        //TODO
    }

    private static void assertArrayEqualTo(int index, Integer[] expected, Integer[] actual) {
        assertTrue(expected.length > index);
        assertTrue(actual.length > index);
        assertEquals(expected.length, actual.length);
    }
}
