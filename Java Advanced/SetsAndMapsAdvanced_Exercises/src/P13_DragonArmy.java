import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P13_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();
        int numberOfDragons = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfDragons; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String type = info[0];
            String name = info[1];
            int damage = 45;
            int health = 250;
            int armor = 10;

            if(!info[2].equals("null")) {
                damage = Integer.parseInt(info[2]);
            }
            if(!info[3].equals("null")) {
                health = Integer.parseInt(info[3]);
            }
            if(!info[4].equals("null")) {
                armor = Integer.parseInt(info[4]);
            }

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).putIfAbsent(name, new int[3]);
            dragons.get(type).get(name)[0] = damage;
            dragons.get(type).get(name)[1] = health;
            dragons.get(type).get(name)[2] = armor;
        }

        for (Map.Entry<String, TreeMap<String, int[]>> entry : dragons.entrySet()) {
            String type = entry.getKey();
            TreeMap<String, int[]> dragonsStats = entry.getValue();
            double[] averageStats = getAverageStats(dragonsStats);
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, averageStats[0], averageStats[1], averageStats[2]);
            dragonsStats.forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", k, v[0], v[1], v[2]));
        }
    }

    public static double[] getAverageStats(TreeMap<String, int[]> map) {
        double avDamage = 0;
        double avHealth = 0;
        double avArmor = 0;
        for (Map.Entry<String, int[]> entry : map.entrySet()) {
            int[] currStats = entry.getValue();
            avDamage += currStats[0];
            avHealth += currStats[1];
            avArmor += currStats[2];
        }
        avDamage = avDamage / map.size();
        avHealth = avHealth / map.size();
        avArmor = avArmor / map.size();
        double[] result = new double[] {avDamage, avHealth, avArmor};
        return result;
    }
}
