package fr.damienchesneau.presentation;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public class Watcher {
    private final Path directory;
    private boolean showHideFiles;
    private volatile Consumer<String> runNew;
    private volatile Consumer<String> runUpdate;
    private volatile Consumer<String> runDelete;
    private final Object locker = new Object();

    public Watcher(Path directory) {
        this(directory, true);
    }

    public Watcher(Path directory, boolean showHideFiles) {
        this.showHideFiles = showHideFiles;
        Objects.requireNonNull(directory);
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException("Please send a path of a directoy.");
        }
        this.directory = directory;
    }

    private WatchKey initializer() throws IOException, InterruptedException {
        WatchService watcher = directory.getFileSystem().newWatchService();
        directory.register(watcher,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        return watcher.take();
    }

    public void setOnDelete(Consumer<String> runDelete) {
        synchronized (locker) {
            this.runDelete = Objects.requireNonNull(runDelete);
        }
    }

    public void setOnNew(Consumer<String> runNew) {
        synchronized (locker) {
            this.runNew = Objects.requireNonNull(runNew);
        }
    }

    public void setOnUpdate(Consumer<String> runUpdate) {
        synchronized (locker) {
            this.runUpdate = Objects.requireNonNull(runUpdate);
        }
    }

    public void start() throws IOException, InterruptedException {
        WatchKey watckKey = initializer();
        while (!Thread.interrupted()) {
            List<WatchEvent<?>> events = watckKey.pollEvents();
            for (WatchEvent event : events) {
                if (!Files.isHidden(Paths.get(event.context().toString()))) {
                    synchronized (locker) {
                        switch (event.kind().toString()) {
                            case "ENTRY_CREATE":
                                this.runNew.accept(event.context().toString());
                                break;
                            case "ENTRY_DELETE":
                                this.runDelete.accept(event.context().toString());
                                break;
                            case "ENTRY_MODIFY":
                                this.runUpdate.accept(event.context().toString());
                                break;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            Watcher w = new Watcher(Paths.get("/home/damien/"), true);
            w.setOnDelete(System.out::println);
            w.setOnNew(System.out::println);
            w.setOnUpdate(System.out::println);
            w.start();
        } catch (IOException e) {
            System.err.println("Error: " + e.toString());
        } catch (InterruptedException e) {
        }
    }
}
