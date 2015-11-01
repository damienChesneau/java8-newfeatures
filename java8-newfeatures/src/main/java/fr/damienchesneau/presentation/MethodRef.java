package fr.damienchesneau.presentation;

import java.util.Arrays;

/**
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public class MethodRef {

    public static void main(String[] args) {
        new MethodRef().sayHello3();
    }

    public void sayHello3() {
        Arrays.asList(1, 2, 3).forEach(this::hello);
    }

    private void hello(int i) {
        System.out.println("Hello " + i);
    }
}
