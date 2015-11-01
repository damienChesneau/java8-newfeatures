package fr.damienchesneau.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public class DimondOperator {
    public List<String> old() {

        List<List<String>> doubleList = new ArrayList<>();

        return doubleList.stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
