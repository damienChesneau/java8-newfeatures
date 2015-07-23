/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.damienchesneau.presentation;

import java.util.function.BooleanSupplier;
import java.util.function.Function;

/**
 *
 * @author dchesnea
 */
public class LambasExamples {
    public void booleanSupp() {
        BooleanSupplier a = ()-> false;
        System.out.println(a);
    }
    public String standardFunction(Function<Integer ,Boolean> function){
        int parameter = Integer.MIN_VALUE;//Somes complex calculs.
        boolean retLambda = function.apply(parameter);
        return (retLambda)?"I'm verry happy to se that.":"Bad week...";
    }
}
