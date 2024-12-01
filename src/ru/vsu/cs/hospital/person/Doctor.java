package ru.vsu.cs.hospital.person;

import java.util.Arrays;

public class Doctor extends Person {
    private static String hospital;
    private String[] speciality;
    private String location;

    static  {
        hospital = "Воронежская поликлиника Центрального района №4";
    }

    public Doctor(String passport, String name, Gender gender, int age, String[] speciality, String locations) {
        super(passport, name, gender, age);
        this.speciality = speciality;
        this.location = locations;
    }

    @Override
    public String getPassport() {
        return super.getPassport();
    }

    @Override
    public void setPassport(String passport) {
        super.setPassport(passport);
    }

    @Override
    public Gender getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(Gender gender) {
        super.setGender(gender);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public void display() {
        System.out.printf("Доктор %s, %d лет\n", passport, age);
    }

    public String[] getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String[] speciality) {
        this.speciality = speciality;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return Arrays.equals(speciality, doctor.speciality);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(speciality);
        return result;
    }
}