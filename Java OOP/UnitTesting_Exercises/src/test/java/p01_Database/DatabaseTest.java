package p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void testDatabaseCtor() throws OperationNotSupportedException {
        Integer[] expectedElements = {10, 11, 12, 13, 14};

        Database database = new Database(expectedElements);

        Integer[] actualElements = database.getElements();
        assertEquals(expectedElements.length, actualElements.length);
        assertArrayEqualTo(expectedElements.length, expectedElements, actualElements);
    }

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
    public void testAdd() throws OperationNotSupportedException {
        Integer[] initialElements = {10, 11, 12, 13, 14};
        Database database = new Database(initialElements);

        Integer newElement = 15;
        database.add(newElement);

        Integer[] actualElements = database.getElements();
        assertEquals(5 + 1, actualElements.length);
        assertArrayEqualTo(5, initialElements, actualElements);
        assertEquals(newElement, actualElements[5]);
    }

    @Test
    public void testAddToSingleElementDatabase() throws OperationNotSupportedException {
        Integer[] initialElements = {10};
        Database database = new Database(initialElements);

        Integer newElement = 11;
        database.add(newElement);

        Integer[] actualElements = database.getElements();
        assertEquals(2, actualElements.length);
        assertArrayEqualTo(1, initialElements, actualElements);
        assertEquals(newElement, actualElements[1]);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddToMaxElementDatabaseTrows() throws OperationNotSupportedException {
        Integer[] initialElements = new Integer[16];
        Database database = new Database(initialElements);

        database.add(17);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullTrows() throws OperationNotSupportedException {
        Integer[] initialElements = {10, 11, 12, 13, 14};
        Database database = new Database(initialElements);

        database.add(null);
    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        Integer[] initialElements = {10, 11, 12, 13, 14};
        Database database = new Database(initialElements);

        database.remove();

        Integer[] actualElements = database.getElements();
        assertEquals(initialElements.length - 1, actualElements.length);
        assertArrayEqualTo(initialElements.length - 1, initialElements, actualElements);
    }

    @Test
    public void testRemoveFromSingleElementDatabase() throws OperationNotSupportedException {
        Integer[] initialElements = {10};
        Database database = new Database(initialElements);

        database.remove();

        Integer[] actualElements = database.getElements();
        assertEquals(0, actualElements.length);
    }

    @Test
    public void testRemoveTwice() throws OperationNotSupportedException {
        Integer[] initialElements = {10, 11, 12, 13, 14};
        Database database = new Database(initialElements);

        database.remove();
        database.remove();

        Integer[] actualElements = database.getElements();
        assertEquals(initialElements.length - 2, actualElements.length);
        assertArrayEqualTo(initialElements.length - 2, initialElements, actualElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDatabaseTrows() throws OperationNotSupportedException {
        Integer[] initialElements = new Integer[0];
        Database database = new Database(initialElements);

        database.remove();
    }

    @Test
    public void testGetElement() throws OperationNotSupportedException {
        Integer[] expectedElements = {10, 11, 12, 13, 14};

        Database database = new Database(expectedElements);

        Integer[] actualElements = database.getElements();
        assertEquals(expectedElements.length, actualElements.length);
        assertArrayEqualTo(expectedElements.length, expectedElements, actualElements);
    }

    private static void assertArrayEqualTo(int length, Integer[] expected, Integer[] actual) {
        assertTrue(expected.length >= length);
        assertTrue(actual.length >= length);

        for (int i = 0; i < length; i++) {
            assertEquals("Mismatch at " + i + " index.", expected[i], actual[i]);
        }
    }
}
