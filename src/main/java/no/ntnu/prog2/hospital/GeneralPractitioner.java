package no.ntnu.prog2.hospital;

public class GeneralPractitioner extends Doctor {
    /***
     *
     * @param firstName
     * @param lastName
     * @param socialSecurityNumber
     *
     * subclass of abstract class 'Doctor'
     * uses methods heads defined in parent class.
     */

    public GeneralPractitioner(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public void setDiagnosis(Patient patient, String diagnosis) {
        patient.setDiagnosis(diagnosis);
    }
}
