package org.models;

import java.util.Objects;

public class Person {

    private String firstName;
    private String lastName;
    private int birthYear;
    private long birthNumber;

    private Person(PersonBuilder builder)
    {
        this.birthNumber= builder.birthNumber;
        this.birthYear= builder.birthYear;
        this.firstName=builder.firstName;
        this.lastName= builder.lastName;
    }

    public static class PersonBuilder
    {
        private String firstName;
        private String lastName;
        private int birthYear;
        private long birthNumber;
//        public PersonBuilder(String firstName)
//        {
//            this.firstName=firstName;
//        }
        public PersonBuilder(){}
        public Person build() {
            return new Person(this);
        }

        public PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public PersonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public PersonBuilder setBirthYear(int birthYear) {
            this.birthYear = birthYear;
            return this;
        }
        public PersonBuilder setBirthNumber(long birthNumber) {
            this.birthNumber = birthNumber;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                ", birthNumber=" + birthNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear && birthNumber == person.birthNumber && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthYear, birthNumber);
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public long getBirthNumber() {
        return birthNumber;
    }

    public void setBirthNumber(long birthNumber) {
        this.birthNumber = birthNumber;
    }
}
