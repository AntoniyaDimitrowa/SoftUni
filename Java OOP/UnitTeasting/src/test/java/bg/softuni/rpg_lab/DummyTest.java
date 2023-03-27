package bg.softuni.rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class DummyTest {
    @Test
    public void attackedDummyLosesHealth() {
        //Arrange
        Dummy dummy = new Dummy(10, 10);

        //Act
        dummy.takeAttack(5);

        //Assert
        Assert.assertEquals(5, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyCantBeAttacked() {
        //Arrange
        Dummy dummy = new Dummy(0, 10);

        //Act
        dummy.takeAttack(5);
    }

    @Test
    public void deadDummyCanGiveXP() {
        //Arrange
        Dummy dummy = new Dummy(0, 10);

        //Act
        int XP = dummy.giveExperience();

        //Assert
        Assert.assertEquals(XP, 10);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {
        //Arrange
        Dummy dummy = new Dummy(10, 10);

        //Act
        dummy.giveExperience();
    }
}
