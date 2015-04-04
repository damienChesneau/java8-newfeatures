package fr.damienchesneau.presentation;

import java.util.Date;

/**
 * Builder pattern
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class Person {

    private final String firstName;
    private final String lastName;
    private final Date years;
    private final String email;

    public Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.years = builder.years;
        this.email = builder.email;
    }

    public static class Builder {

        private final String firstName;
        private final String lastName;
        private Date years;
        private String email;

        public Builder(final String firstName, final String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
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
