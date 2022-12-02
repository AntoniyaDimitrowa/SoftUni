import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> heroHP = new LinkedHashMap<>();
        Map<String, Integer> heroMP = new LinkedHashMap<>();
        int numberOfHeroes = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfHeroes; i++) {
            String[] heroInfo = scanner.nextLine().split(" ");
            String heroName = heroInfo[0];
            int hp = Integer.parseInt(heroInfo[1]);
            int mp = Integer.parseInt(heroInfo[2]);
            heroHP.put(heroName, hp);
            heroMP.put(heroName, mp);
        }
        String[] commandArr = scanner.nextLine().split(" - ");
        while(!commandArr[0].equals("End")) {
            String command = commandArr[0];
            String heroName = commandArr[1];

            if(command.equals("CastSpell")) {
                int neededMP = Integer.parseInt(commandArr[2]);
                String spellName = commandArr[3];
                if(neededMP <= heroMP.get(heroName)) {
                    int manaPointsLeft = heroMP.get(heroName) - neededMP;
                    heroMP.put(heroName, manaPointsLeft);
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, manaPointsLeft);
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                }

            } else if(command.equals("TakeDamage")) {
                int damage = Integer.parseInt(commandArr[2]);
                String attacker = commandArr[3];
                int leftHP = heroHP.get(heroName) - damage;
                if(leftHP > 0) {
                    heroHP.put(heroName, leftHP);
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, leftHP);
                } else {
                    heroHP.remove(heroName);
                    heroMP.remove(heroName);
                    System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                }

            } else if(command.equals("Recharge")) {
                int amount = Integer.parseInt(commandArr[2]);
                int currMP = heroMP.get(heroName);
                int newMP = amount + currMP;
                if(newMP > 200) {
                    newMP = 200;
                }
                heroMP.put(heroName, newMP);
                int recoveredAmount = newMP - currMP;
                System.out.printf("%s recharged for %d MP!%n", heroName, recoveredAmount);

            } else if(command.equals("Heal")) {
                int amount = Integer.parseInt(commandArr[2]);
                int currHP = heroHP.get(heroName);
                int newHP = amount + currHP;
                if(newHP > 100) {
                    newHP = 100;
                }
                heroHP.put(heroName, newHP);
                int healedAmount = newHP - currHP;
                System.out.printf("%s healed for %d HP!%n", heroName, healedAmount);
            }
            commandArr = scanner.nextLine().split(" - ");
        }

        for (Map.Entry<String, Integer> entry : heroHP.entrySet()) {
            String heroName = entry.getKey();
            int currHeroHP = entry.getValue();
            int currHeroMP = heroMP.get(heroName);

            System.out.println(heroName);
            System.out.printf("  HP: %d%n", currHeroHP);
            System.out.printf("  MP: %d%n", currHeroMP);
        }
    }
}
