package bg.softuni.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    private Target target;

    @Before
    public void setupDummy() {
        this.target = new Dummy(10, 10);
    }
    @Test
    public void attackDropsDurability() {
        //Arrange
        int durability = 10;
        Axe axe = new Axe(10, durability);

        //Act
        axe.attack(this.target);

        //Assert
        Assert.assertEquals(durability - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void cannotAttackWithBrokenAxe() {
        //Arrange
        Axe axe = new Axe(10, 1);

        //Act
        axe.attack(this.target);
        axe.attack(this.target);
    }
}
