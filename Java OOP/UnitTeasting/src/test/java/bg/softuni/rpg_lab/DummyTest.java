package bg.softuni.rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final int INITIAL_DUMMY_HEALTH = 10;
    private static final int INITIAL_DUMMY_EXPERIENCE = 10;
    private Target dummy;

    @Before
    public void setup() {
        this.dummy = new Dummy(INITIAL_DUMMY_HEALTH, INITIAL_DUMMY_EXPERIENCE);
    }

    @Test
    public void attackedDummyLosesHealth() {
        //Arrange
        int attackPoints = 5;

        //Act
        this.dummy.takeAttack(attackPoints);

        //Assert
        Assert.assertEquals(INITIAL_DUMMY_HEALTH - attackPoints, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyCantBeAttacked() {
        //Act
        this.dummy.takeAttack(10);
        this.dummy.takeAttack(10);
    }

    @Test
    public void deadDummyCanGiveXP() {
        //Arrange
        this.dummy.takeAttack(10);

        //Act
        int XP = dummy.giveExperience();

        //Assert
        Assert.assertEquals(XP, INITIAL_DUMMY_EXPERIENCE);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP() {
        //Act
        this.dummy.giveExperience();
    }
}
