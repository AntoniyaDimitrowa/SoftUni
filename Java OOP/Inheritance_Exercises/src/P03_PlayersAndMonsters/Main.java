package P03_PlayersAndMonsters;

import P03_PlayersAndMonsters.hero.*;

public class Main {
    public static void main(String[] args) {
        BladeKnight bladeKnight = new BladeKnight("Asuna", 9);
        DarkKnight darkKnight = new DarkKnight("Kirirto", 10);
        DarkWizard darkWizard = new DarkWizard("Gargamel", 5);
        Elf elf = new Elf("Liefa", 7);
        MuseElf museElf = new MuseElf("Karina", 7);
        Knight knight = new Knight("Gosho", 2);
        SoulMaster soulMaster = new SoulMaster("Arter", 8);
        Wizard wizard = new Wizard("Alex", 6);

        System.out.println(bladeKnight);
        System.out.println(darkKnight);
        System.out.println(darkWizard);
        System.out.println(elf);
        System.out.println(museElf);
        System.out.println(knight);
        System.out.println(soulMaster);
        System.out.println(wizard);


    }
}
