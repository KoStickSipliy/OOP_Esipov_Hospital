package ru.vsu.cs.hospital;

import java.util.Arrays;
import java.util.Objects;

public class Illness {
    private String name;
    private String[] symptoms;
    {
        //name = "Неизвестная болезнь";
        name = "Неизвестная болезнь";
        symptoms = new String[]{"Не выявлены"};
    }

    public Illness(String name, String[] symptoms) {
        this.name = name;
        this.symptoms = symptoms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String[] symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Illness illness = (Illness) o;
        return Objects.equals(name, illness.name) && Arrays.equals(symptoms, illness.symptoms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, symptoms);
    }
}
