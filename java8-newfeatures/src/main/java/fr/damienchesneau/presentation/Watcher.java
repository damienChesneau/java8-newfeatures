package fr.damienchesneau.presentation;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public class Watcher {

    public static void main(String[] args) {
        Path directory = Paths.get("/home/damien/");
        System.out.println("Watching the " + directory.getFileName() + " directory ...");
        try {
            WatchService watcher = directory.getFileSystem().newWatchService();
            directory.register(watcher,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
            WatchKey watckKey = watcher.take();
            while (!Thread.interrupted()) {
                List<WatchEvent<?>> events = watckKey.pollEvents();

                for (WatchEvent event : events) {
                    if (!event.context().toString().startsWith("."))
                        System.out.println("This file : '" + event.context().toString() + "' was " + event.kind().toString() + ".");
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.toString());
        } catch (InterruptedException e) {
            return;
        }
    }
}
