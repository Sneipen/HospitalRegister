package no.ntnu.prog2.hospital;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DepartmentTest {

    private final Department department = new Department("Cancer");
    private final Department department2 = new Department("Intensive");
    private final Patient patient = new Patient("Kaare","Berg","12345678901");
    private final Patient patient2 = new Patient("Ingebrigt","Strand","11111555599");
    private final Employee employeeWithSameSSN = new Employee("Linda","Fyshe","55544422209");
    private final Employee surgeon = new Surgeon("Frida","Moan","55544422209");
    private final Nurse nurse = new Nurse("Nils","Fredheim","00998877665");
    private final Patient patientWithUsedSSN = new Patient("Frid", "Eide", "12345678901");

    @Nested
    class addValidEmployeeAndPatient{

        @Test
        void can_add_employee() throws IllegalArgumentException {
            try {
                department.addEmployee(surgeon);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            Assertions.assertEquals(department.getEmployees().get(0), surgeon);
        }

        @Test
        void can_add_patient() throws IllegalArgumentException {
            try {
                department.addPatient(patient);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            Assertions.assertEquals(department.getPatients().get(0), patient);
        }

    }

    @Nested
    class canAddExistingPatientAndEmployeeToAnotherDepartment {

        @Test
        void addPatientFromDepartmentToAnother() throws IllegalArgumentException {
            try {
                department2.addPatient(patient);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            try {
                department.addPatient(patient);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            Assertions.assertTrue(department.getPatients().size() == 1);
        }

        @Test
        void addExistingEmployeeFromOneDepartmentToAnother() throws IllegalArgumentException {
            try {
                department.addEmployee(surgeon);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            try {
                department2.addEmployee(surgeon);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            Assertions.assertEquals(department2.getEmployees(), department.getEmployees());
        }
    }

    @Nested
    class cannotAddEmployeeOrPatientWithUsedSSN{

        @Test
        void addPatientWithUsedSSN() throws IllegalArgumentException {
            department.addPatient(patient);
            try{
                department.addPatient(patientWithUsedSSN);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        @Test
        void addEmployeeWithUsedSSN() throws IllegalArgumentException {
            department.addEmployee(surgeon);
            try {
                department.addEmployee(employeeWithSameSSN);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Nested
    class removeTestSuccess {
        @Test
        void canRemoveExistingEmployee() throws RemoveException {
            department.addEmployee(nurse);
            try {
                department.remove(nurse);
            }catch (RemoveException e) {
                System.out.println(e.getMessage());
            }
            Assertions.assertTrue(department.getEmployees().size() == 0);
        }

        @Test
        void canRemoveExistingPatient() throws RemoveException {
            department.addPatient(patient);
            try {
                department.remove(patient);
            }catch (RemoveException e) {
                System.out.println(e.getMessage());
            }
            Assertions.assertTrue(department.getPatients().size() == 0);
        }
    }

    @Nested
    class RemoveTestFail {
        @Test
        void CannotRemoveNonExistingEmployee() throws RemoveException {
            department.addEmployee(surgeon);
            try{
                department.remove(nurse);
            }catch (RemoveException e) {
                System.out.println(e.getMessage());
            }
            Assertions.assertTrue(department.getEmployees().size() == 1);
        }

        @Test
        void CannotRemoveNonExistingPatient() throws RemoveException {
            department.addPatient(patient);
            try {
                department.remove(patient2);
            }catch (RemoveException e) {
                System.out.println(e.getMessage());
            }
            Assertions.assertTrue(department.getPatients().size() == 1);
        }
    }


}






