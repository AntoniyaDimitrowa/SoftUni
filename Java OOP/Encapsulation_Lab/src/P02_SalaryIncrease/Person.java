package P02_SalaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        double actualBonus = bonus;
        if(this.getAge() < 30) {
            actualBonus /= 2;
        }
        double newSalary = this.getSalary() * (1 + actualBonus/100);
        this.setSalary(newSalary);
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %f leva.",
                this.getFirstName(),
                this.getLastName(),
                this.getSalary());
    }
}
