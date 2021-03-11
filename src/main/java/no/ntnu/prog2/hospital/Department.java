package no.ntnu.prog2.hospital;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Department {

    private String departmentName;
    private ArrayList<Employee> employees;
    private ArrayList<Patient> patients;

    public Department(String departmentName) {
        if(!(departmentName).equals("")) {
            this.departmentName = departmentName;
            this.employees = new ArrayList<>();
            this.patients = new ArrayList<>();
        } else {
            throw new IllegalArgumentException("Department name can not be empty.");
        }

    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void addEmployee(Employee toAdd) {
        if(!(iteratePerson(toAdd))) employees.add(toAdd);
        else throw new IllegalArgumentException("Employee with social security number '" +
                toAdd.getSocialSecurityNumber() + "', already exists in system.");
    }

    public void addPatient(Patient toAdd) {
        if(!(iteratePerson(toAdd))) patients.add(toAdd);
        else throw new IllegalArgumentException("Patient with social security number '" +
                toAdd.getSocialSecurityNumber() + "', already exists in system.");
    }

    public void remove(Person person) throws RemoveException {
        boolean exists = iteratePerson(person);
        if(exists) {
            if(person instanceof Employee) employees.remove(person);
            else if(person instanceof Patient) patients.remove(person);
        }
        else throw new RemoveException("Unable to remove " + person.getFullName() +
                " from department '" + this.getDepartmentName() + "'.");
    }


    private boolean iteratePerson(Person person) {
        if(person instanceof Employee) {
            Iterator<Employee> employeeIterator = employees.iterator();
            Employee toCheck;
            while(employeeIterator.hasNext()) {
                toCheck = employeeIterator.next();
                if(toCheck.equals(person)) return true;
            }
            return false;
        }
        else if(person instanceof Patient) {
            Iterator<Patient> patientIterator = patients.iterator();
            Patient toCheck;
            while(patientIterator.hasNext()) {
                toCheck = patientIterator.next();
                if(toCheck.equals(person)) return true;
            }
        }
        return false;
    }



    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;

        Department toCheck = (Department) obj;
        boolean isEqual = false;

        if((this.getDepartmentName().equals(toCheck.getDepartmentName())) ||
           (this.getEmployees().equals(toCheck.getEmployees()) &&
            this.getPatients().equals(toCheck.getPatients()))) isEqual = true;

        return isEqual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, employees, patients);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                ", patients=" + patients +
                '}';
    }
}
