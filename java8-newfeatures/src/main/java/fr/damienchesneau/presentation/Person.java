package fr.damienchesneau.presentation;

import java.util.Date;
import java.util.Objects;

/**
 * Builder pattern
 *
 * @author Damien Chesneau - contact@damienchesneau.fr 
 */
public class Person {

    private final String firstName;
    private final String lastName;
    private final Date years;
    private final String email;

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.years = builder.years;
        this.email = builder.email;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person){
            Person p = (Person) obj;
            return p.firstName.equals(this.firstName) && 
                     p.lastName.equals(this.lastName) &&
                     p.years.equals(this.years) &&
                     p.email.equals(this.firstName);
        }
        return false;
    }

    @Override
    public String toString() {
        return firstName +" " +lastName+((years==null)?"":" "+years.toString())+((email==null)?"":" "+email);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + Objects.hashCode(this.years);
        hash = 97 * hash + Objects.hashCode(this.email);
        return hash;
    }
    
    public static class Builder {

        private final String firstName;
        private final String lastName;
        private Date years;
        private String email;

        public Builder(final String firstName, final String lastName) {
            this.firstName = Objects.requireNonNull(firstName, "Please this filds requiere a non null String.");
            this.lastName = Objects.requireNonNull(lastName, "Please this filds requiere a non null String.");
        }

        public Builder setYears(Date years) {
            this.years = years;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
