package bg.softuni.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HeroTest {
    private static final int INITIAL_DUMMY_HEALTH = 10;
    private static final int INITIAL_DUMMY_EXPERIENCE = 10;
    private static final Weapon INITIAL_HERO_WEAPON = new Axe(10, 10);
    private Hero hero;
    private Dummy dummy;

    @Before
    public void setup() {
        this.hero = new Hero("Georgi", INITIAL_HERO_WEAPON);
        this.dummy = new Dummy(INITIAL_DUMMY_HEALTH, INITIAL_DUMMY_EXPERIENCE);
    }

    @Test
    public void getName() {
        Assert.assertEquals(this.hero.getName(), "Georgi");
    }

    @Test
    public void getExperience() {
        Assert.assertEquals(this.hero.getExperience(), 0);
        this.hero.attack(dummy);
        Assert.assertEquals(this.hero.getExperience(), 10);
    }

    @Test
    public void getWeapon() {
        Weapon weapon = this.hero.getWeapon();
        Assert.assertEquals(weapon.getAttackPoints(), 10);
    }
}
