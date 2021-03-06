package no.ntnu.prog2.hospital;

public class Employee extends Person {

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public String toString() {
        return "Employee{ " + super.toString() + " }";
    }
}
