package robots;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ServiceTests {

    @Test(expected = NullPointerException.class)
    public void testCreateServiceWhenNullNameThrows() {
        new Service(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateServiceWhenEmptyNameThrows() {
        new Service("      ", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateServiceWhenNegativeCapacityThrows() {
        new Service("valid", -10);
    }

    @Test
    public void testCreateServiceWithZeroCapacity() {
        new Service("valid", 0);
    }

    @Test
    public void testCreateServiceWithValidNameAndPositiveCapacity() {
        new Service("valid", 10);
    }

    @Test
    public void testGetName() {
        Service service = new Service("valid", 10);

        assertEquals("valid", service.getName());
    }

    @Test
    public void testGetCapacity() {
        Service service = new Service("valid", 10);

        assertEquals(10, service.getCapacity());
    }

    @Test
    public void testGetCountIsZeroOnEmptyService() {
        Service service = new Service("valid", 10);

        assertEquals(0, service.getCount());
    }

    @Test
    public void testGetCount() {
        Service service = new Service("valid", 10);
        Robot r1 = new Robot("Robot1");
        Robot r2 = new Robot("Robot2");

        service.add(r1);
        service.add(r2);

        assertEquals(2, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotWhenServiceIsFullThrows() {
        Service service = new Service("valid", 1);
        Robot r1 = new Robot("Robot1");
        Robot r2 = new Robot("Robot2");

        service.add(r1);
        service.add(r2);
    }

    @Test
    public void testAddRobotIncreasesCount() {
        Service service = new Service("valid", 10);
        Robot r1 = new Robot("Robot1");
        Robot r2 = new Robot("Robot2");

        service.add(r1);
        service.add(r2);

        assertEquals(2, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRobotWhenServiceIsEmptyThrows() {
        Service service = new Service("valid", 1);

        service.remove("Robot1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveRobotThatDoesNotExistThrows() {
        Service service = new Service("valid", 1);
        Robot r1 = new Robot("Robot1");
        service.add(r1);

        service.remove("robotAboutToRemove");
    }

    @Test
    public void testRemoveRobotDecreasesCount() {
        Service service = new Service("valid", 10);
        Robot r1 = new Robot("Robot1");
        Robot r2 = new Robot("Robot2");
        Robot r3 = new Robot("Robot3");
        service.add(r1);
        service.add(r2);
        service.add(r3);

        service.remove(r2.getName());

        assertEquals(2, service.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleWhenServiceIsEmptyThrows() {
        Service service = new Service("valid", 1);

        service.forSale("robotForSale");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForSaleWhenRobotDoesNotExistThrows() {
        Service service = new Service("valid", 1);
        Robot r1 = new Robot("Robot1");
        service.add(r1);

        service.forSale("robotForSale");
    }

    @Test
    public void testForSaleWithExistingRobot() {
        Service service = new Service("valid", 10);
        Robot r1 = new Robot("Robot1");
        Robot r2 = new Robot("Robot2");
        Robot r3 = new Robot("Robot3");
        service.add(r1);
        service.add(r2);
        service.add(r3);

        Robot robotForSale = service.forSale(r2.getName());

        assertFalse(robotForSale.isReadyForSale());
        assertEquals(r2, robotForSale);
    }

    @Test
    public void testReport() {
        Service service = new Service("valid", 10);
        Robot r1 = new Robot("Robot1");
        Robot r2 = new Robot("Robot2");
        Robot r3 = new Robot("Robot3");
        service.add(r1);
        service.add(r2);
        service.add(r3);

        String expected = "The robot " + r1.getName() + ", " + r2.getName() + ", " + r3.getName() + " is in the service " + service.getName() + "!";
        String actual = service.report();

        assertEquals(expected, actual);
    }
}
