package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DatabaseTest {

    private static Person[] defaultInitialPersonArray;

    @Before
    public void setUp() {
        Person p1 = new Person(1, "User1");
        Person p2 = new Person(2, "User2");
        Person p3 = new Person(3, "User3");
        defaultInitialPersonArray = new Person[] {p1, p2, p3};
    }

    @Test
    public void testDatabaseCtor() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        Person[] actualElements = database.getElements();
        assertEquals(defaultInitialPersonArray.length, actualElements.length);
        assertArrayEqualTo(defaultInitialPersonArray.length, defaultInitialPersonArray, actualElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseCtorMoreThan16ElementsTrows() throws OperationNotSupportedException{ //constructor
        Person[] largerArray = new Person[16 + 1];
        Database database = new Database(largerArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseCtorLessThan1ElementsTrows() throws OperationNotSupportedException { //constructor
        Person[] largerArray = new Person[0];
        Database database = new Database(largerArray);
    }

    @Test
    public void testDatabaseCtorInitializes16Capacity() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException { //constructor
        Database database = new Database(defaultInitialPersonArray);

        Field elementsField = Database.class.getDeclaredField("elements");
        elementsField.setAccessible(true);
        Person[] elements = (Person[]) elementsField.get(database);
        assertEquals(16, elements.length);
    }

    @Test
    public void testAdd() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        Person newPerson = new Person(4, "User4");
        database.add(newPerson);

        Person[] actualElements = database.getElements();
        assertEquals(3 + 1, actualElements.length);
        assertArrayEqualTo(3, defaultInitialPersonArray, actualElements);
        assertEquals(newPerson, actualElements[3]);
    }

    @Test
    public void testAddToSingleElementDatabase() throws OperationNotSupportedException {
        Person[] initialElements = {new Person(1, "User1")};
        Database database = new Database(initialElements);

        Person newPerson = new Person(2, "User2");
        database.add(newPerson);

        Person[] actualElements = database.getElements();
        assertEquals(2, actualElements.length);
        assertArrayEqualTo(1, initialElements, actualElements);
        assertEquals(newPerson, actualElements[1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddToMaxElementDatabaseTrows() throws OperationNotSupportedException {
        Person[] initialElements = new Person[16];
        Database database = new Database(initialElements);

        Person newPerson = new Person(17, "User17");
        database.add(newPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullTrows() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonWithNegativeIdTrows() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        Person p1 = new Person(-1, "User-1");
        database.add(p1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonWithNullIdTrows() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        Person p0 = new Person(0, "User0");
        database.add(p0);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonWithAlreadyExistingIdTrows() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        Person p1 = new Person(1, "User123");
        database.add(p1);
    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        database.remove();

        Person[] actualElements = database.getElements();
        assertEquals(defaultInitialPersonArray.length - 1, actualElements.length);
        assertArrayEqualTo(defaultInitialPersonArray.length - 1, defaultInitialPersonArray, actualElements);
    }

    @Test
    public void testRemoveFromSingleElementDatabase() throws OperationNotSupportedException {
        Person[] initialElements = {new Person(1, "User1")};
        Database database = new Database(initialElements);

        database.remove();

        Person[] actualElements = database.getElements();
        assertEquals(0, actualElements.length);
    }

    @Test
    public void testRemoveTwice() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        database.remove();
        database.remove();

        Person[] actualElements = database.getElements();
        assertEquals(defaultInitialPersonArray.length - 2, actualElements.length);
        assertArrayEqualTo(defaultInitialPersonArray.length - 2, defaultInitialPersonArray, actualElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDatabaseTrows() throws OperationNotSupportedException {
        Person[] initialElements = new Person[0];
        Database database = new Database(initialElements);

        database.remove();
    }

    @Test
    public void testGetElement() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        Person[] actualElements = database.getElements();
        assertEquals(defaultInitialPersonArray.length, actualElements.length);
        assertArrayEqualTo(defaultInitialPersonArray.length, defaultInitialPersonArray, actualElements);
    }

    @Test
    public void testFindByUsername() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        Person p = database.findByUsername("User1");

        assertEquals("User1", p.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWhenThereIsNoSuchUserThrows() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        database.findByUsername("NotExistingUsername");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWhenUsernameIsNullThrows() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        database.findByUsername(null);
    }

    @Test
    public void testFindById() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        Person p = database.findById(1);

        assertEquals(1, p.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdWhenThereIsNoSuchUserThrows() throws OperationNotSupportedException {
        Database database = new Database(defaultInitialPersonArray);

        database.findById(0);
    }

    private static void assertArrayEqualTo(int length, Person[] expected, Person[] actual) {
        assertTrue(expected.length >= length);
        assertTrue(actual.length >= length);

        for (int i = 0; i < length; i++) {
            assertEquals("Mismatch at " + i + " index!", expected[i], actual[i]);
        }
    }
}
