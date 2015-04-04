package fr.damienchesneau.presentation;

import java.util.function.Supplier;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class InnerCalc {

    public boolean getValue(Supplier<String> supplier, String maString) {
        String supp = supplier.get();
        return supp.contains(maString);
    }
}
