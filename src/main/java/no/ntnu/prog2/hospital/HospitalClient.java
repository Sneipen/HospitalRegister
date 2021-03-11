package no.ntnu.prog2.hospital;
public class HospitalClient {

    public static void fillRegisterWithTestData(final Hospital hospital) {

        // Add some departments together with some employees and patients.

        Department emergency = new Department("Akutten");
        emergency.getEmployees().add(new Employee("Odd Even", "Primtallet", "12345678901"));
        emergency.getEmployees().add(new Employee("Huppasahn", "DelFinito", "95734263464"));
        emergency.getEmployees().add(new Employee("Rigmor", "Mortis", "65357435436"));
        emergency.getEmployees().add(new GeneralPractitioner("Inco", "Gnito", "11122233344"));
        emergency.getEmployees().add(new Surgeon("Inco", "Gnito", "11122233346"));
        emergency.getEmployees().add(new Nurse("Nina", "Teknologi", "0987625372"));
        emergency.getEmployees().add(new Nurse("Ove", "Ralt", "3251346236"));
        emergency.getPatients().add(new Patient("Inga", "Lykke", "53463456346"));
        emergency.getPatients().add(new Patient("Ulrik", "Smål", "12343264634"));
        hospital.getDepartments().add(emergency);
        Department childrenPolyclinic = new Department("Barn poliklinikk");
        childrenPolyclinic.getEmployees().add(new Employee("Salti", "Kaffen", "5345326136"));
        childrenPolyclinic.getEmployees().add(new Employee("Nidel V.", "Elvefølger", "5326334643"));
        childrenPolyclinic.getEmployees().add(new Employee("Anton", "Nym", "3243267657"));
        childrenPolyclinic.getEmployees().add(new GeneralPractitioner("Gene", "Sis", "5324673277"));
        childrenPolyclinic.getEmployees().add(new Surgeon("Nanna", "Na", "3334455663"));
        childrenPolyclinic.getEmployees().add(new Nurse("Nora", "Toriet", "1112356744"));
        childrenPolyclinic.getPatients().add(new Patient("Hans", "Omvar", "6768999675"));
        childrenPolyclinic.getPatients().add(new Patient("Laila", "La", "1215436737"));
        childrenPolyclinic.getPatients().add(new Patient("Jøran", "Drebli", "7653243674"));
        hospital.getDepartments().add(childrenPolyclinic);
    }


    public static void main(String[] args) {

        Hospital hospital = new Hospital("St. Olavs Hospital");
        String stars = "**************************************************";

        fillRegisterWithTestData(hospital);

        // Prints objects before removal of employee:
        for(Department department: hospital.getDepartments()) {
            System.out.println(department.toString() + "\n" + stars + "\n");
        }

        //Remove an existing employee=Anton from children polyclinic:
        try{
            hospital.getDepartments().get(1).remove(hospital.getDepartments().get(1).getEmployees().get(2));
        }catch (RemoveException e){
            System.out.println(e.getMessage());
        }
        //Prints updated list of department affected:

        System.out.println(hospital.getDepartments().get(1).toString());

        //Removes patient=Inga from emergency:
        try {
            hospital.getDepartments().get(0).remove(hospital.getDepartments().get(0).getPatients().get(0));
        }catch (RemoveException e) {
            System.out.println(e.getMessage());
        }

        //Tries to remove non-existing patient (Tries to remove patient from emergency, when patient only exists
        // in children polyclinic):
        try {
            hospital.getDepartments().get(0).remove(hospital.getDepartments().get(1).getPatients().get(1));
        }catch (RemoveException e) {
            System.out.println(e.getMessage());
        }
    }
}
