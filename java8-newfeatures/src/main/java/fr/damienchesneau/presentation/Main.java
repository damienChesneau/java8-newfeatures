package fr.damienchesneau.presentation;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public class Main {

    public static void main(String[] args) {
        Supplier<String> ftSupplier = () -> {
            URL url;
            try {
                url = new URI("http://damienchesneau.fr").toURL();
                try (InputStream openStream = url.openStream();
                        InputStreamReader ssd = new InputStreamReader(openStream);) {
                    return ssd.getEncoding();
                } catch (IOException ex) {
                    System.err.println("ERROR !");
                }
            } catch (URISyntaxException | MalformedURLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        };
        Supplier<String> scSupplier = () -> {
            return "UTF-8";
        };
        InnerCalc a = new InnerCalc();
        boolean test = a.getValue(scSupplier, "UTF-8");
        System.out.println(test);

        Person p1 = new Person.Builder("Damien", "Chesneau").setEmail("contact@damienchesneau.fr").build();
        Person p2 = new Person.Builder("Toto", "NomToto").setEmail("toto@gmail.com").build();
        Person p3 = new Person.Builder("Titi", "NomTiti").setEmail("titi@gmail.com").build();
        Person p4 = new Person.Builder("Tutu", "NomTutu").setEmail("tutu@gmail.com").build();
        System.out.println(p1);

//        Stream<Integer> generate = Stream.generate(() -> 1);
//        System.out.println(generate.count());
        String[] val = {"a", "b", "coucou"};
        List<String> list = new ArrayList<>();
        list.add("sdsd");
        list.add("etsscqcqsdt");
        list.add("etst");
        
        System.out.println("Contains = " + list.contains("etst"));
        int vaa = Arrays.binarySearch(val, "coucou");
        System.out.println(vaa >= 0);
        Path get = Paths.get("df", "fd.php", "sqsq.txt");
        System.out.println(get.toString());

        LambasExamples le = new LambasExamples();
        String toPrint = le.standardFunction((i) -> {
            return !(i > 3000);
        });
        System.out.println(toPrint);
    }    
}
