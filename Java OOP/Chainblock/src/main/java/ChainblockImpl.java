import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{
    HashMap<Integer, Transaction> transactionsById = new HashMap<>();
    HashMap<String, HashMap<Integer, Transaction>> transactionsBySender = new HashMap<>();
    HashMap<String, HashMap<Integer, Transaction>> transactionsByReceiver = new HashMap<>();

    public HashMap<String, HashMap<Integer, Transaction>> getTransactionsBySender() {
        return transactionsBySender;
    }

    public HashMap<String, HashMap<Integer, Transaction>> getTransactionsByReceiver() {
        return transactionsByReceiver;
    }

    @Override
    public int getCount() {
        return transactionsById.size();
    }

    @Override
    public void add(Transaction transaction) {
        if(contains(transaction)) {
            return;
        }
        transactionsById.put(transaction.getId(), transaction);

        HashMap<Integer, Transaction> forThisSender = transactionsBySender.get(transaction.getFrom());
        if(forThisSender == null) {
            forThisSender = new HashMap<>();
            transactionsBySender.put(transaction.getFrom(), forThisSender);
        }
        forThisSender.put(transaction.getId(), transaction);

        HashMap<Integer, Transaction> forThisReceiver = transactionsByReceiver.get(transaction.getTo());
        if(forThisReceiver == null) {
            forThisReceiver = new HashMap<>();
            transactionsByReceiver.put(transaction.getTo(), forThisReceiver);
        }
        forThisReceiver.put(transaction.getId(), transaction);
    }

    @Override
    public boolean contains(Transaction transaction) {
        return this.contains(transaction.getId());
    }

    @Override
    public boolean contains(int id) {
        return getByIdOrNull(id) != null;
    }

    @Override
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        Transaction transaction = getById(id);
        if(transaction == null) {
            throw new IllegalArgumentException();
        }

        transaction.setStatus(newStatus);
    }

    @Override
    public void removeTransactionById(int id) {
        Transaction removed = transactionsById.remove(id);

        if(removed == null) {
            throw new IllegalArgumentException();
        }

        HashMap<Integer, Transaction> forThisSender = transactionsBySender.get(removed.getFrom());
        if(forThisSender != null) {
            forThisSender.remove(id);
        }

        HashMap<Integer, Transaction> forThisReceiver = transactionsBySender.get(removed.getTo());
        if(forThisReceiver != null) {
            forThisReceiver.remove(id);
        }
    }

    @Override
    public Transaction getById(int id) {
        Transaction transaction = getByIdOrNull(id);

        if(transaction == null) {
            throw new IllegalArgumentException();
        }

        return transaction;
    }

    private Transaction getByIdOrNull(int id) {
        return transactionsById.get(id);
    }

    @Override
    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        return null;
    }

    @Override
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    @Override
    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
//        return transactionsById.values().stream()
//                .sorted((a, b) -> {
//                    if(b.getAmount() == a.getAmount()) {
//                        return Double.compare(b.getAmount(), a.getAmount());
//                    }
//                    return Integer.compare(a.getId(), b.getId());
//                })
//                .collect(Collectors.toList());

        return transactionsById.values().stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    @Override
    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    @Override
    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    @Override
    public Iterator<Transaction> iterator() {
        return null;
    }
}
