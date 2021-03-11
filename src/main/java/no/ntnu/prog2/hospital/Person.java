package no.ntnu.prog2.hospital;

public abstract class Person {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    /***
     *
     * @param firstName = Persons first name
     * @param lastName  = Persons last name
     * @param socialSecurityNumber  = unique SSN for all Persons in all Departments
     */

    public Person(String firstName, String lastName, String socialSecurityNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    /***
     *
     * @param obj
     * @return boolean
     *
     * self defined equals method to compare different person objects
     * The method is designed in hand with methods personIterator and remove/add methods.
     *
     * The method allows employees and patients to exist in different departments
     * Employees is also able to be registered as a patient, as they could get sick/hurt
     * and therefore enter a department as a patient.
     */

    @Override
    public boolean equals(Object obj) {
        String socialSecNum;
        if(this == obj) return true;
        else if(this.getClass() == Patient.class) {
            if((obj == null) || (this.getClass() != obj.getClass())) return false;
                socialSecNum = ((Patient)obj).getSocialSecurityNumber();
                return this.getSocialSecurityNumber().equals(socialSecNum);
        }else {
            socialSecNum = ((Employee)obj).getSocialSecurityNumber();
            return this.getSocialSecurityNumber().equals(socialSecNum);
        }
    }

    @Override
    public String toString() {
        return "Name: " + getFullName() + ".\nSocial security number: " + getSocialSecurityNumber();
    }
}
