package ru.vsu.cs.hospital.person;

import ru.vsu.cs.hospital.DocException;
import ru.vsu.cs.hospital.Illness;
import ru.vsu.cs.hospital.MedicalCard;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person  implements DoctorsCare{
    private int room;
    private String[] allergies;
    public List<MedicalCard> medCards;
    public Doctor attendingDoctor;
    private String location;
    {
        room = -1;
        allergies = null;
        medCards = null;
    }
    public Patient(String passport, String name, Gender gender, int age, int room, String[] allergies) {
        super(passport, name, gender, age);
        this.room = room;
        this.allergies = allergies;
        this.medCards = new ArrayList<>();
    }
    public Patient(String passport, String name, Gender gender, int age, int room) {
        super(passport, name, gender, age);
        this.room = room;
        this.medCards = new ArrayList<>();
    }
    public Patient() {

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

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String[] getAllergies() {
        return allergies;
    }

    public void setAllergies(String[] allergies) {
        this.allergies = allergies;
    }

    public List<MedicalCard> getAllMedCards() {
        return medCards;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public MedicalCard getMedCard(int i) {
        return medCards.get(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public void display() {
        System.out.printf("Пациент %s, %s, %d лет, палата %s\n", passport, passport, age, room);
    }

    @Override
    public void addMedCard (MedicalCard newMC) {
        medCards.add(newMC);
        System.out.printf("Медкарта добавлена: %s (%s).\n", newMC.getIllness().getName(), newMC.getIllness().getSymptoms());
    }
//    public void addMedCard (Illness ill, MedicalCard.Severity severity, String treatment) {
//        medCards.add(new MedicalCard(ill, severity, treatment));
//        System.out.printf("Медкарта пациента %s добавлена: %s (%s).\n", this.getPassport(), ill.getName(), ill.getSymptoms());
//    }


    @Override
    public void assignDoctor(Doctor doc) throws DocException {
        if (doc.getLocation().equals(location) && !medCards.isEmpty()) {
           attendingDoctor = doc;
        } else if (!doc.getLocation().equals(location)) {
            throw new DocException("Нет свободных докторов для пациента");
        } else if (medCards.isEmpty()) {
            throw new DocException("Нет болезней");
        }
    }

    @Override
    public void updateMedCard(MedicalCard card, Illness ill, MedicalCard.Severity severity, String treatment) throws DocException{
        if (card.getIllness().equals(ill) &&
            card.getSeverity().equals(severity) &&
            card.getTreatment().equals(treatment)) {
            return;
        }
        card.setIllness(ill);
        card.setSeverity(severity);
        card.setTreatment(treatment);
    }
}


