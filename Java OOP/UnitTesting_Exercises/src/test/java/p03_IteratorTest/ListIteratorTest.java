package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator iteratorWith_0_1_2;

    @Before
    public void setUp() throws OperationNotSupportedException {
        iteratorWith_0_1_2 = new ListIterator("0", "1", "2");
    }

    @Test
    public void testListCtorAndIteration() {
        assertEquals("0", iteratorWith_0_1_2.print());
        iteratorWith_0_1_2.move();
        assertEquals("1", iteratorWith_0_1_2.print());
        iteratorWith_0_1_2.move();
        assertEquals("2", iteratorWith_0_1_2.print());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCtorWhenNullArgumentTrows() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNext() {
        assertTrue(iteratorWith_0_1_2.hasNext());
    }

    @Test
    public void testHasNextWhenEmpty() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testHasNextWhenReachedEnd() {
        iteratorWith_0_1_2.move();
        iteratorWith_0_1_2.move();

        assertFalse(iteratorWith_0_1_2.hasNext());
    }

    @Test
    public void testHasNextWhenReachedMiddle() {
        iteratorWith_0_1_2.move();

        assertTrue(iteratorWith_0_1_2.hasNext());
    }

    @Test
    public void testMove() {
        assertTrue(iteratorWith_0_1_2.move());

        assertEquals("1", iteratorWith_0_1_2.print());
    }

    @Test
    public void testMoveWhenSingleElement() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator("0");

        assertFalse(iterator.move());

        assertEquals("0", iterator.print());
    }

    @Test
    public void testMultipleMoveReachesEnd() {
        assertTrue(iteratorWith_0_1_2.move());
        assertTrue(iteratorWith_0_1_2.move());
        assertFalse(iteratorWith_0_1_2.move());

        assertEquals("2", iteratorWith_0_1_2.print());
    }

    @Test
    public void testMoveWhenNoElements() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();

        assertFalse(iterator.move());
    }

    @Test
    public void testPrint() {
        assertEquals("0", iteratorWith_0_1_2.print());
    }

    @Test
    public void testPrintTwice() {
        assertEquals("0", iteratorWith_0_1_2.print());
        assertEquals("0", iteratorWith_0_1_2.print());
    }

    @Test
    public void testPrintWhenNoElements() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();

        expectException(() -> iterator.print(), IllegalStateException.class, "Invalid Operation!");
    }

    private static <T extends Throwable> void expectException(Runnable r, Class<T> clazz, String message) {
        T actualException = null;
        try {
            r.run();
        } catch(Throwable e) {
            actualException = (T) e;
        }

        assertNotNull(actualException);
        assertEquals(clazz, actualException.getClass());
        assertEquals(message, actualException.getMessage());
    }
}
