package fr.damienchesneau.presentation;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Function;

/**
 *
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public class LambasExamples {

    public void booleanSupp() {
        BooleanSupplier a = () -> false;
        System.out.println(a);
    }

    public String standardFunction(Function<Integer, Boolean> function) {
        int parameter = Integer.MIN_VALUE;//Somes complex calculs.
        boolean retLambda = function.apply(parameter);
        return (retLambda) ? "I'm verry happy to se that." : "Bad week...";
    }

    public int max(int val1, int val2, Logger log) {
        Objects.requireNonNull(log, "Please use correct logger.");
        if (val1 > val2) {
            log.log("Val2 is the max.", 2);
            return val2;
        } else {
            log.log("Val1 is the max.", 2);
            return val1;
        }
    }
}
