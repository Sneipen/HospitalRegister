package no.ntnu.prog2.hospital;

public abstract class Doctor extends Employee {

    protected Doctor(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    public abstract void setDiagnosis(Patient patient, String diagnosis);
}
