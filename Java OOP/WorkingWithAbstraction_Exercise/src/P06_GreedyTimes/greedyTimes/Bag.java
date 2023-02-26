package P06_GreedyTimes.greedyTimes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private final Map<String, Cash> cashList;
    private final Map<String, Gem> gemList;
    private final Gold gold;
    private final long capacity;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.cashList = new LinkedHashMap<>();
        this.gemList = new LinkedHashMap<>();
        this.gold = new Gold("Gold", 0);
    }

    public void add(String typeName, String name, long quantity) {
        switch (typeName) {
            case "Gem":
                addGem(name, quantity);
                break;
            case "Cash":
                addCash(name, quantity);
                break;
            case "Gold":
                addGold(quantity);
                break;
        }
    }

    private void addGem(String name, long quantity) {
        Gem current;
        if(this.gemList.containsKey(name)) {
            current = this.gemList.get(name);
            current.setQuantity(quantity + current.getQuantity());
        } else {
            current = new Gem(name, quantity);
        }
        this.gemList.put(name, current);
    }

    private void addCash(String name, long quantity) {
        Cash current;
        if(this.cashList.containsKey(name)) {
            current = this.cashList.get(name);
            current.setQuantity(quantity + current.getQuantity());
        } else {
            current = new Cash(name, quantity);
        }
        this.cashList.put(name, current);
    }

    private void addGold(long quantity) {
        this.gold.setQuantity(this.gold.getQuantity() + quantity);
    }

    public boolean canAdd(String typeName, long quantity) {
        if(!checkIfThereIsEnoughSpace(quantity)) {
            return false;
        }

        switch (typeName) {
            case "Gem":
                if (isBiggerThanGoldQuantity(this.getTotalGems() + quantity)) {
                    return false;
                }
                break;
            case "Cash":
                if (isBiggerThanGemQuantity(this.getTotalCash() + quantity)) {
                    return false;
                }
                break;
        }
        return true;
    }

    private long getTotalGems() {
       return this.gemList.values()
               .stream()
               .mapToLong(e -> e.getQuantity())
               .sum();
    }

    private long getTotalGold() {
        return this.gold.getQuantity();
    }

    private long getTotalCash() {
        return this.cashList.values()
                .stream()
                .mapToLong(e -> e.getQuantity())
                .sum();
    }

    private boolean checkIfThereIsEnoughSpace(long quantity) {
        if(this.getTotalCash() + this.getTotalGold() + this.getTotalGems() + quantity > capacity) {
            return false;
        }
        return true;
    }

    private boolean isBiggerThanGemQuantity(long quantity) {
        return quantity > this.getTotalGems();
    }

    private boolean isBiggerThanGoldQuantity(long quantity) {
        return quantity > this.getTotalGold();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Map<String, Long> types = new HashMap<>();
        types.put("gold", this.getTotalGold());
        types.put("gems", this.getTotalGems());
        types.put("cash", this.getTotalCash());

        types.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    switch (e.getKey()) {
                        case "gold":
                            if(this.getTotalGold() != 0) {
                                sb.append(String.format("<Gold> $%d%n", this.getTotalGold()));
                                sb.append(String.format(gold.toString())).append(System.lineSeparator());
                            }
                            break;
                        case "gems":
                            if(this.getTotalGems() != 0) {
                                sb.append(String.format("<Gem> $%d%n", this.getTotalGems()));
                                this.gemList.values().stream()
                                        .sorted((g1, g2) -> {
                                            int result = g2.getName().compareTo(g1.getName());
                                            if (result == 0) {
                                                result = Long.compare(g1.getQuantity(), g2.getQuantity());
                                            }
                                            return result;
                                        })
                                        .forEach(g -> sb.append(g).append(System.lineSeparator()));
                                break;
                            }
                        case "cash":
                            if(this.getTotalCash() != 0) {
                                sb.append(String.format("<Cash> $%d%n", this.getTotalCash()));
                                this.cashList.values().stream()
                                        .sorted((c1, c2) -> {
                                            int result = c2.getName().compareTo(c1.getName());
                                            if (result == 0) {
                                                result = Long.compare(c1.getQuantity(), c2.getQuantity());
                                            }
                                            return result;
                                        })
                                        .forEach(g -> sb.append(g).append(System.lineSeparator()));
                                break;
                            }
                    }
                });
        return sb.toString().trim();
    }
}
