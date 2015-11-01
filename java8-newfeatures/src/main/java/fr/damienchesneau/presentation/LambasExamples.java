package fr.damienchesneau.presentation;

import java.util.function.BooleanSupplier;
import java.util.function.Function;

/**
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
        return (retLambda) ? "Hello" : "Oops";
    }

    public void max(int val1, int val2, Logger log) {
        Function<Integer, String> validatClass = new Function<Integer, String>() {
            @Override
            public String apply(Integer val) {
                return (val > 25) ? "OK" : "NOK";
            }
        };

        Function<Integer, String> validateLambda = (val) -> {
            return (val > 25) ? "OK" : "NOK";
        };

        Function<Integer, String> lambGen = LambasExamples::lambda$1;
    }

    public static String lambda$1(Integer val) {
        return (val > 25) ? "OK" : "NOK";
    }

}
