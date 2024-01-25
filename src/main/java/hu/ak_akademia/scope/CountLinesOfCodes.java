package hu.ak_akademia.scope;

import java.nio.file.Files;
import java.nio.file.Path;

public class CountLinesOfCodes {
    public long calculateTotalLines(Path directory) {
        try {
            return Files.walk(directory)
                    .filter(path -> path.toString().endsWith(".java"))
                    .map(CountLinesOfCodes::countLines)
                    .reduce(0L, Long::sum);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static long countLines(Path file) {
        try {
            return Files.lines(file).count();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
