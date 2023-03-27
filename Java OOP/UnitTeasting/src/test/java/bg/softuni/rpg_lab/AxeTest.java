package bg.softuni.rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class AxeTest {

    @Test
    public void weaponAttacksLosesDurability() {
        //Arrange
        Axe axe = new Axe(10, 10);
        Dummy target = new Dummy(10, 10);

        //Act
        axe.attack(target);

        //Assert
        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCantAttack() {
        //Arrange
        Axe axe = new Axe(10, 1);
        Dummy target = new Dummy(20, 10);

        //Act
        axe.attack(target);
        axe.attack(target);
    }
}
