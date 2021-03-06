package no.ntnu.prog2.hospital;

public class Nurse extends Employee {

    public Nurse(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public String toString() {
        return "Nurse{ Name: " + getFullName() +
                "\nSocial security number: " + getSocialSecurityNumber();
    }
}
