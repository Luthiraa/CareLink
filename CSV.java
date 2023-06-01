import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CSV {
    public void newCSV() {
        String inputFile = "CSVfiles/data_shelter.csv"; // Replace with your input CSV file
        String outputFile = "CSVfiles/shelters.csv"; // Replace with the desired output CSV file
        int columnIndex = 4; // Specify the index of the column to check uniqueness (0-based index)

        try {
            Set<String> uniqueValues = new HashSet<>();
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                // Check if the column value is unique
                if (!uniqueValues.contains(columns[columnIndex])) {
                    uniqueValues.add(columns[columnIndex]);
                    writer.write(line);
                    writer.newLine();
                }
            }

            reader.close();
            writer.close();
            System.out.println("Unique rows have been written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}