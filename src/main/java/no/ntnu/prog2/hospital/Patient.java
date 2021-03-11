package no.ntnu.prog2.hospital;

public class Patient extends Person implements Diagnosable {
    private String diagnosis;


    protected Patient(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    /***
     *
     * protected due to sensitive information.
     */

    protected String getDiagnosis() {
        return this.diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "Patient { " + super.toString() + " \nDiagnosis: " + getDiagnosis() + " }";
    }
}
