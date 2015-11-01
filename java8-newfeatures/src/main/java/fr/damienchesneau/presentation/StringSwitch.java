package fr.damienchesneau.presentation;

/**
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public class StringSwitch {

    public void swithInStr(String value) {
        switch (value) {
            case "car":
                break;
            case "bike":
                break;
            case "airplane":
                break;
            default:
                throw new AssertionError();
        }

    }
}
