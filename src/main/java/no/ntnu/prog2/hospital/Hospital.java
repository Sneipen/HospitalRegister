package no.ntnu.prog2.hospital;

import java.util.ArrayList;
import java.util.Iterator;

public class Hospital {
    private String hospitalName;
    private ArrayList<Department> departments;

    public Hospital(String hospitalName) {
        if(!(hospitalName).equals("")) {
            this.hospitalName = hospitalName;
            this.departments = new ArrayList<>();
        } else {
            throw new IllegalArgumentException("Hospital name can not be empty.");
        }
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

//    public Department getDepartmentByName(String departmentName) {
//        for(Department department:departments) {
//            if(department.getDepartmentName().equals(departmentName)) return department;
//        }
//        return null;
//    }

    private boolean iterateDepartments(Department department) {
        Iterator<Department> iterator = departments.iterator();
        Department toCheck;
        if(iterator.hasNext()) {
            toCheck = iterator.next();
            if(toCheck.equals(department)) return true;
        }
        return false;
    }


    public void addDepartment(Department toAdd) {
        if(!(iterateDepartments(toAdd))) departments.add(toAdd);
        else throw new IllegalArgumentException("Department '" + toAdd.getDepartmentName() +
                "', already exists in system.");
    }


    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalName='" + hospitalName + '\'' +
                ", departments=" + departments +
                '}';
    }
}
