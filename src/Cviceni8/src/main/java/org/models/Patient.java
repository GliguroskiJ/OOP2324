package org.models;

import java.util.Objects;

public class Patient {

    private int ID;
    private String firstName;
    private String lastName;
// Constructor, Equals, Hashcode,
// Get/Set, ToString()
    public Patient(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return ID == patient.ID && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName);
    }
}
