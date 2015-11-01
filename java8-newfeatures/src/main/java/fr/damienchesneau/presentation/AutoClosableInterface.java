package fr.damienchesneau.presentation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public class AutoClosableInterface {

    public void auto() throws IOException {

        Path p = Paths.get("beautifulfile");
        try (Stream<String> lines = Files.lines(p).map(s -> s/*Complex calc thow ex.*/)) {
            //Error
        }
    }

    public void autov1() throws IOException {

        Path p = Paths.get("beautifulfile");
        try (Stream<String> lines = Files.lines(p)) {
            //ok
        }
    }

}
