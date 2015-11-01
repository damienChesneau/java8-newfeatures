package fr.damienchesneau.presentation;

import java.util.List;

/**
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public interface PersonSrv {
    void add(Person p);

    void update(Person p);

    void delete(Person p);

    List<Person> getAll();

    default boolean exist(Person p) {
        return getAll().contains(p);
    }
}

