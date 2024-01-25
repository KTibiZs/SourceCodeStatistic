package hu.ak_akademia.scope;

import java.io.File;
import java.util.Arrays;

public class ProjectCount {
    public long projectCount (File[] projectsPath) {
        return Arrays.stream(projectsPath)
                .filter(File::isDirectory)
                .count();
    }
}
