package fr.damienchesneau.presentation;

import java.util.function.Supplier;

/**
 *
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public class InnerCalc {

    public boolean getValue(Supplier<String> supplier, String maString) {
        String supp = supplier.get();
        if (supp.contains(maString)) {
            System.out.println("Yahouuu on est en " + maString);
        } else {
            String subSequence = (String) supp.subSequence(0, 2);
//            System.out.println(subSequence.contains((String)maString.subSequence(0, 2)));
            System.out.println("Oupppss on n'as pas la valeur : " + maString + " dans : " + supp);
        }
        return supp.contains(maString);
    }
}
