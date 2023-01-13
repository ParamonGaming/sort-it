import java.io.*;
import java.util.*;

public class FileProcessor<T> {
    private List<T> inputData;
    private File outputFile;

    public FileProcessor(List<String> inputFilesPath, String outputFile) {
        this.inputData = new ArrayList<>();
        this.outputFile = new File(outputFile);
        List<File> inputFiles = new ArrayList<>();
        for(String path : inputFilesPath){
            inputFiles.add(new File(path));
        }
        for (File inputFile : inputFiles) {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    T data = (T) line;
                    inputData.add(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public List<T> getInputData() {
        return inputData;
    }
    public void writeOutputFile(List<T> sorted) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (T data : sorted) {
                writer.write(data.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
