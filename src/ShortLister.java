import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        Filter filter = new ShortWordFilter();

        try {

            File workingDirectory = new File(System.getProperty("user.dir"));


            chooser.setCurrentDirectory(workingDirectory);


            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                System.out.println("Short words (length < 5) from file " + selectedFile.getName() + ":");
                System.out.println("----------------------------------------");
                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    line++;

                    for (String word : rec.split("\\s+")) {
                        String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");

                        if (!cleanWord.isEmpty() && filter.accept(cleanWord)){
                            System.out.println(cleanWord);
                        }
                    }

                }
                reader.close();
                System.out.println("\n\nData file read!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

