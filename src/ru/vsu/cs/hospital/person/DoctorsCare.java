package ru.vsu.cs.hospital.person;

import ru.vsu.cs.hospital.Illness;
import ru.vsu.cs.hospital.MedicalCard;

public interface DoctorsCare {
    public void assignDoctor(Doctor doc);
    public void addMedCard(MedicalCard newMC);
    public void updateMedCard(MedicalCard card, Illness ill, MedicalCard.Severity severity, String treatment);
}
