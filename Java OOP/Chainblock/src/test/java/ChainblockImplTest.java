import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    @Test
    public void testGetCount() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setupTransaction(1));
        chainblock.add(setupTransaction(2));

        assertEquals(2, chainblock.getCount());
    }

    @Test
    public void testGetCountEmpty() {
        ChainblockImpl chainblock = new ChainblockImpl();

        assertEquals(0, chainblock.getCount());
    }

    @Test
    public void testAdd() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setupTransaction(1, "defaultSender", "defaultReceiver"));
        chainblock.add(setupTransaction(2, "defaultSender", "defaultReceiver"));
        chainblock.add(setupTransaction(2000, "defaultSender", "defaultReceiver"));
        chainblock.add(setupTransaction(-5000, "defaultSender", "defaultReceiver"));

        List<Transaction> actual = getListFrom(chainblock.getAllOrderedByAmountDescendingThenById());
        assertTransactionIdsEqual(Arrays.asList(-5000, 1, 2, 2000), actual);

        List<Transaction> transactionsFromSender = getListFrom(chainblock.getTransactionsBySender().get("defaultSender").values());
        assertTransactionIdsEqual(Arrays.asList(-5000, 1, 2, 2000), transactionsFromSender.stream().sorted(Comparator.comparing(Transaction::getId)).collect(Collectors.toList()));

        List<Transaction> transactionsToReceiver = getListFrom(chainblock.getTransactionsByReceiver().get("defaultReceiver").values());
        assertTransactionIdsEqual(Arrays.asList(-5000, 1, 2, 2000), transactionsToReceiver.stream().sorted(Comparator.comparing(Transaction::getId)).collect(Collectors.toList()));
    }

    @Test
    public void testAddSingle() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setupTransaction(1, "defaultSender", "defaultReceiver"));


        List<Transaction> actual = getListFrom(chainblock.getAllOrderedByAmountDescendingThenById());
        assertTransactionIdsEqual(Collections.singletonList(1), actual);

        List<Transaction> transactionsFromSender = getListFrom(chainblock.getTransactionsBySender().get("defaultSender").values());
        assertTransactionIdsEqual(Arrays.asList(1), transactionsFromSender);

        List<Transaction> transactionsToReceiver = getListFrom(chainblock.getTransactionsByReceiver().get("defaultReceiver").values());
        assertTransactionIdsEqual(Arrays.asList(1), transactionsToReceiver);
    }

    @Test
    public void testAddDuplicateTransactionDoesNotAdd() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setupTransaction(1, TransactionStatus.SUCCESSFUL));
        chainblock.add(setupTransaction(2));
        chainblock.add(setupTransaction(1, TransactionStatus.UNAUTHORIZED));

        List<Transaction> actual = getListFrom(chainblock.getAllOrderedByAmountDescendingThenById());
        assertEquals(1, actual.get(0).getId());
        assertEquals(TransactionStatus.SUCCESSFUL, actual.get(0).getStatus());
        assertTransactionIdsEqual(Arrays.asList(1, 2), actual);
    }

    @Test
    public void testContainsExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();

        Transaction searchTransaction = setupTransaction(1);
        chainblock.add(searchTransaction);
        chainblock.add(setupTransaction(2));

        assertTrue(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsExistingTransactionWhenSingleTransactionInChainblock() {
        ChainblockImpl chainblock = new ChainblockImpl();

        Transaction searchTransaction = setupTransaction(1);
        chainblock.add(searchTransaction);

        assertTrue(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsExistingTransactionWithDifferentPropertiesReturnsTrue() {
        ChainblockImpl chainblock = new ChainblockImpl();
        Transaction transaction = setupTransaction(1);
        chainblock.add(transaction);
        Transaction searchTransaction = setupTransaction(1);
        searchTransaction.setStatus(TransactionStatus.ABORTED);

        assertTrue(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsSameIdTransactionDifferentObjectInstance() {
        ChainblockImpl chainblock = new ChainblockImpl();

        Transaction transaction = setupTransaction(1);
        chainblock.add(transaction);

        Transaction searchTransaction = setupTransaction(1);
        assertTrue(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsNonExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setupTransaction(1));
        chainblock.add(setupTransaction(2));

        Transaction searchTransaction = setupTransaction(3);

        assertFalse(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsEmptyChainblock() {
        ChainblockImpl chainblock = new ChainblockImpl();

        Transaction searchTransaction = setupTransaction(3);

        assertFalse(chainblock.contains(searchTransaction));
    }

    @Test
    public void testContainsByIdExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setupTransaction(1));
        chainblock.add(setupTransaction(2));

        assertTrue(chainblock.contains(1));
    }

    @Test
    public void testContainsByIdNonExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();

        chainblock.add(setupTransaction(1));
        chainblock.add(setupTransaction(2));

        assertFalse(chainblock.contains(3));
    }

    @Test
    public void testContainsByIdEmptyChainblock() {
        ChainblockImpl chainblock = new ChainblockImpl();

        assertFalse(chainblock.contains(3));
    }

    @Test
    public void testChangeStatusExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setupTransaction(1, TransactionStatus.SUCCESSFUL));
        chainblock.add(setupTransaction(2, TransactionStatus.SUCCESSFUL));

        chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);

        assertEquals(TransactionStatus.ABORTED, chainblock.getById(1).getStatus());
        assertEquals(TransactionStatus.SUCCESSFUL, chainblock.getById(2).getStatus());
        throw new IllegalStateException("TODO");
    }

    @Test
    public void testChangeStatusNonExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setupTransaction(1, TransactionStatus.SUCCESSFUL));
        chainblock.add(setupTransaction(2, TransactionStatus.SUCCESSFUL));

        Throwable actualException;
        try {
            chainblock.changeTransactionStatus(3, TransactionStatus.ABORTED);
            actualException = null;
        } catch(IllegalArgumentException e) {
            actualException = e;
        }

        assertNotNull(actualException);
        assertEquals(TransactionStatus.SUCCESSFUL, chainblock.getById(1).getStatus());
        assertEquals(TransactionStatus.SUCCESSFUL, chainblock.getById(2).getStatus());
        throw new IllegalStateException("TODO");
    }

    @Test
    public void testRemoveExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setupTransaction(1, "defaultSender", "defaultReceiver"));
        chainblock.add(setupTransaction(2, "defaultSender", "defaultReceiver"));
        chainblock.add(setupTransaction(3, "defaultSender", "defaultReceiver"));

        chainblock.removeTransactionById(2);

        List<Transaction> remaining = getListFrom(chainblock.getAllOrderedByAmountDescendingThenById());
        assertTransactionIdsEqual(Arrays.asList(1, 3), remaining);

        List<Transaction> transactionsFromSender = getListFrom(chainblock.getTransactionsBySender().get("defaultSender").values());
        assertTransactionIdsEqual(Arrays.asList(1, 3), transactionsFromSender.stream().sorted(Comparator.comparing(Transaction::getId)).collect(Collectors.toList()));

        List<Transaction> transactionsToReceiver = getListFrom(chainblock.getTransactionsByReceiver().get("defaultReceiver").values());
        assertTransactionIdsEqual(Arrays.asList(1, 3), transactionsToReceiver.stream().sorted(Comparator.comparing(Transaction::getId)).collect(Collectors.toList()));
    }

    @Test
    public void testRemoveMultipleExistingTransactions() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setupTransaction(1, "defaultSender", "defaultReceiver"));
        chainblock.add(setupTransaction(2, "defaultSender", "defaultReceiver"));
        chainblock.add(setupTransaction(3, "defaultSender", "defaultReceiver"));

        chainblock.removeTransactionById(2);
        chainblock.removeTransactionById(3);

        List<Transaction> remaining = getListFrom(chainblock.getAllOrderedByAmountDescendingThenById());
        assertTransactionIdsEqual(Arrays.asList(1), remaining);
    }

    @Test
    public void testRemoveOnlyTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setupTransaction(1, "defaultSender", "defaultReceiver"));

        chainblock.removeTransactionById(1);

        List<Transaction> remaining = getListFrom(chainblock.getAllOrderedByAmountDescendingThenById());
        assertEquals(0, remaining.size());

        List<Transaction> transactionsFromSender = getListFrom(chainblock.getTransactionsBySender().get("defaultSender").values());
        assertEquals(0, transactionsFromSender.size());

        List<Transaction> transactionsToReceiver = getListFrom(chainblock.getTransactionsByReceiver().get("Receiver1").values());
        assertEquals(0, transactionsToReceiver.size());
    }

    @Test
    public void testRemoveOnlyTransactionOfOneSender() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setupTransaction(1, "Sender1", "defaultReceiver"));
        chainblock.add(setupTransaction(2, "Sender2", "defaultReceiver"));
        chainblock.add(setupTransaction(3, "Sender2", "defaultReceiver"));

        chainblock.removeTransactionById(1);

        List<Transaction> remaining = getListFrom(chainblock.getAllOrderedByAmountDescendingThenById());
        assertEquals(2, remaining.size());

        List<Transaction> transactionsFromSender1 = getListFrom(chainblock.getTransactionsBySender().get("Sender1").values());
        assertEquals(0, transactionsFromSender1.size());

        List<Transaction> transactionsToReceiver = getListFrom(chainblock.getTransactionsByReceiver().get("defaultReceiver").values());
        assertTransactionIdsEqual(Arrays.asList(1, 3), transactionsToReceiver.stream().sorted(Comparator.comparing(Transaction::getId)).collect(Collectors.toList()));
    }

    @Test
    public void testRemoveOnlyTransactionOfOneReceiver() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setupTransaction(1, "defaultSender", "Receiver1"));
        chainblock.add(setupTransaction(2, "defaultSender", "Receiver2"));
        chainblock.add(setupTransaction(3, "defaultSender", "Receiver2"));

        chainblock.removeTransactionById(1);

        List<Transaction> remaining = getListFrom(chainblock.getAllOrderedByAmountDescendingThenById());
        assertEquals(2, remaining.size());

        List<Transaction> transactionsFromSender = getListFrom(chainblock.getTransactionsBySender().get("defaultSender").values());
        assertTransactionIdsEqual(Arrays.asList(1, 3), transactionsFromSender.stream().sorted(Comparator.comparing(Transaction::getId)).collect(Collectors.toList()));

        List<Transaction> transactionsToReceiver1 = getListFrom(chainblock.getTransactionsByReceiver().get("Receiver1").values());
        assertEquals(0, transactionsToReceiver1.size());
    }

    @Test
    public void testRemoveNonExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setupTransaction(1));

        Throwable actualException;
        try {
            chainblock.removeTransactionById(3);
            actualException = null;
        } catch (IllegalArgumentException e) {
            actualException = e;
        }

        assertNotNull(actualException);
        List<Transaction> remaining = getListFrom(chainblock.getAllOrderedByAmountDescendingThenById());
        assertEquals(1, remaining.size());
    }

    @Test
    public void testGetByIdExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setupTransaction(1));
        chainblock.add(setupTransaction(2));
        chainblock.add(setupTransaction(3));

        Transaction transaction = chainblock.getById(2);

        assertEquals(2, transaction.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdNonExistingTransaction() {
        ChainblockImpl chainblock = new ChainblockImpl();
        chainblock.add(setupTransaction(1));
        chainblock.add(setupTransaction(2));
        chainblock.add(setupTransaction(3));

        Transaction transaction = chainblock.getById(4);
    }

    private static void assertTransactionIdsEqual(List<Integer> expectedIds, List<Transaction> actual) {
        assertEquals(expectedIds.size(), actual.size());
        for (int i = 0; i < expectedIds.size(); i++) {
            assertEquals((int) expectedIds.get(i), actual.get(i).getId());
        }
    }

    private static Transaction setupTransaction(int id) {
        return setupTransaction(id, TransactionStatus.SUCCESSFUL);
    }

    private static Transaction setupTransaction(int id, String sender, String receiver) {
        return new TransactionImpl(id, TransactionStatus.SUCCESSFUL, sender, receiver, 42.0);
    }

    private static Transaction setupTransaction(int id, TransactionStatus status) {
        return new TransactionImpl(id, status, "from", "to", 42.0);
    }

    private static <T> List<T> getListFrom(Iterable<T> iterable) {
        ArrayList<T> list = new ArrayList<>();

        for (T item : iterable) {
            list.add(item);
        }

        return list;
    }
}
