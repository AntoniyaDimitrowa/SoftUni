package p02_ExtendedDatabase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void testCtor() {
        Person person = new Person(1, "Toni");

        assertEquals(1, person.getId());
        assertEquals("Toni", person.getUsername());
    }
}
