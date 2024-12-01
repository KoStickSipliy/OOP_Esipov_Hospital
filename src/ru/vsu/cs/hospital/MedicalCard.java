package ru.vsu.cs.hospital;

import java.util.Objects;

public class MedicalCard {
    private Illness illness;
    private String treatment;
    private Severity severity;
    private boolean isTreated = false;

    {
        illness = null;
        treatment = "-";
        severity = null;
    }

    public MedicalCard(Illness illness, Severity severity, String treatment) {
        this.illness = illness;
        this.treatment = treatment;
        this.severity = severity;
    }


    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public boolean isTreated() {
        return isTreated;
    }

    public void setTreated () {
        this.isTreated = true;
        System.out.printf("%s вылечен.\n", this.illness.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalCard that = (MedicalCard) o;
        return isTreated == that.isTreated
                && Objects.equals(illness, that.illness)
                && Objects.equals(treatment, that.treatment)
                && severity == that.severity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(illness, treatment, severity, isTreated);
    }

    // Возможны методы, в которых бы вычислялся порядок обхода пациентов докторами.
    // Для этого нужны численные приоритеты в зависимости от тяжести.
    public enum Severity {
        LOW (3),
        MEDIUM (2),
        HIGH (1);
        private int priority;
        Severity(int priority) {
            this.priority = priority;
        }
        public int getPriority () {
            return priority;
        }
    }
}
