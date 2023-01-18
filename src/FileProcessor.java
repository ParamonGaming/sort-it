import java.io.*;
import java.util.*;

public class FileProcessor<T> {
    private File outputFile;

    public FileProcessor(List<String> inputFilesPath, String outputFile) {
        this.outputFile = new File(outputFile);
        List<File> inputFiles = new ArrayList<>();
        for(String path : inputFilesPath){
            inputFiles.add(new File(path));
        }
        processFiles(inputFiles,this.outputFile);
}
    public void processFiles(List<File> files, File outputFile) {
        List<T> data = new ArrayList<>();
        for (File file : files) {
            data.addAll( getDataFromFile(file));
        }
        writeOutputFile(data);
    }
    public List<T> getDataFromFile(File file)
    {   List<T> datas = new ArrayList<T>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() > 0 && !line.contains(" ")) {
                    T data = (T) line;
                    datas.add(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }

    public void writeOutputFile(List<T> sorted) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (T data : sorted) {
                writer.write(data.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to output file: " + e.getMessage());
        }
    }
}
