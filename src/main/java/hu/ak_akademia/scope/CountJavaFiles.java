package hu.ak_akademia.scope;

import java.io.File;
public class CountJavaFiles {
    public int countJavaFiles(String folderPath) {
        File actualFolder = new File(folderPath);

        // check folders for exist
        if (!actualFolder.exists() || !actualFolder.isDirectory()) {
            System.err.println("Nem létező mappa!");
            return 0;
        }

        // if folders exist do counting
        return recursiveCountingForJavaFiles(actualFolder);
    }

    private int recursiveCountingForJavaFiles(File folder) {
        // the recursion using for "open" subdirectory (in this case) until there is no more and do counting .java files etc...
        int javaFileCounter = 0;

        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    javaFileCounter += recursiveCountingForJavaFiles(file);
                } else if (file.isFile() && file.getName().endsWith(".java")) {
                    javaFileCounter++;
                }
            }
        }
        return javaFileCounter;
    }
}
