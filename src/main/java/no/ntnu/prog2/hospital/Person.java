package no.ntnu.prog2.hospital;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

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
