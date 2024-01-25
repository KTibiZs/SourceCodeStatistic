package hu.ak_akademia.scope;

import java.io.File;
public class Main {
    final static String PATH = "C:\\ak_scope";
    public static void main(String[] args) {
        new Main().run(PATH);
    }
    public void run(String path) {
        try {
            File projectsPath = new File(path);
            CountJavaFiles countJavaFiles = new CountJavaFiles();
            CountLinesOfCodes countLinesOfCodes = new CountLinesOfCodes();
            ProjectCount projectCounter = new ProjectCount();

            // counting directories
            long projectsCount = projectCounter.projectCount(projectsPath.listFiles());

            // counting .java files
            int javaFilesCount = countJavaFiles.countJavaFiles(path);

            // counting lines of codes
            long totalLinesCount = countLinesOfCodes.calculateTotalLines(projectsPath.toPath());

            // output
            System.out.print("A(z) " + path + " mappában " + projectsCount + " projekt, azokban " +
                    javaFilesCount + " forrás fájl található, " + "a forrássorok teljes száma: " + totalLinesCount);

        } catch (NullPointerException e) {
            System.out.println("A mappa/file nem található, ellenőrizze az elérési utat.\nA program leáll.");
        }
    }
}
