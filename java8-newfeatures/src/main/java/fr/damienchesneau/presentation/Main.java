package fr.damienchesneau.presentation;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.function.Supplier;

/**
 *
 * @author Damien Chesneau <contact@damienchesneau.fr>
 */
public class Main {

    public static void main(String[] args) {
        Supplier<String> ftSupplier = () -> {
            try {
                URL url = new URI("http://damienchesneau.fr").toURL();
                InputStream openStream = url.openStream();
                BufferedInputStream buf = new BufferedInputStream(openStream);
                InputStreamReader ssd = new InputStreamReader(openStream);
                return ssd.getEncoding();
            } catch (IOException | URISyntaxException ex) {
                System.err.println("ERROR !");
            }
            return null;
        };
        Supplier<String> scSupplier = () -> {
            return "UTF-8";
        };

        InnerCalc a = new InnerCalc();
        boolean test = a.getValue(scSupplier, "UTF-8");
        System.out.println(test);
    }
}
