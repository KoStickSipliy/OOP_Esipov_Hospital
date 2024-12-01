package ru.vsu.cs.hospital;

import ru.vsu.cs.hospital.person.Patient;
import ru.vsu.cs.hospital.person.Person;

public class Main {
    public static void main(String[] args) {
        Illness flu = new Illness("Грипп", new String[]{"кашель, насморк, повышенная температура"});
        Patient A1123 = new Patient(
                "2003 293986",
                "Виталий Рогоза",
                Person.Gender.MALE,
                28,
                12
        );
        A1123.display();
        MedicalCard A1123MedCard = new MedicalCard(flu, MedicalCard.Severity.MEDIUM, "терафлю 3 раза в день в течение 10 дней");
        A1123.addMedCard(A1123MedCard);

        A1123.getMedCard(0).setTreated(); // грипп вылечен

    }
}
