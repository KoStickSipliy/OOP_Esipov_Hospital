package ru.vsu.cs.hospital.person;

import java.util.Objects;

public class Person {
    protected String passport;
    protected String name;
    protected Gender gender;
    protected int age;

    {
        passport = " - ";
        name = "Пациент";
        gender = null;
        age = -1;
    }
    public Person(String passport, String name, Gender gender, int age) {
        this.passport = name;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    public Person () {

    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(passport, person.passport) && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport, name);
    }

    public void display () {
        System.out.printf("%s, %d лет\n", passport, age);
    }

    public enum Gender {
        MALE,
        FEMALE;
    }
}
