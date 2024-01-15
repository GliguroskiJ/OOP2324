package org.cv.model;

import java.util.Objects;

public class Patient {
    // Vlastnosti/Atributy/Parametry tridy
    private String name;
    private String surname;
    private int year;

    public Patient(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return year == patient.year && Objects.equals(name, patient.name) && Objects.equals(surname, patient.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year);
    }

    @Override
    public String toString() {
        return String.format("Pacient se jmenem: %s a prijmenim: %s se narodil v: %d",name,this.surname,this.year);
/*        return "Patient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                '}';*/
    }
}
