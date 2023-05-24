import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HospitalLocator {
    public void readCoords() {
        String csvFile = "CSVfiles/hospital.csv";
        String delimiter = ","; // CSV delimiter
        GPSLocation gpsLocation = new GPSLocation();
        String [][] nearbyShelters =  new String[1][2];

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(delimiter);
                if (columns.length >= 2) {
                    String latitude = columns[1];
                    double dlat = Double.parseDouble(latitude);
                    String longitude = columns[2];
                    double dlong = Double.parseDouble(longitude);
                    String hName = columns[0];
                    gpsLocation.getUserLocation();
                    String[] locationParts = gpsLocation.getUserLocationData().split(",");
                    double userLatitude = Double.parseDouble(locationParts[15].split(":")[1].trim());
                    double userLongitude = Double.parseDouble(locationParts[16].split(":")[1].trim());
                    double distance = gpsLocation.calculateDistance(userLatitude, userLongitude, dlat, dlong);
                    if (distance <10){
                        nearbyShelters[0][0] = hName;
                        nearbyShelters[0][1] = String.valueOf(distance);
                    }
                }
                
            }
            for (int i = 0; i < nearbyShelters.length; i++) {
                // Iterate over the columns
                for (int j = 0; j < nearbyShelters[i].length; j++) {
                    // Print the element at the current position
                    System.out.print(nearbyShelters[i][j] + " ");
                }
                // Move to the next line after printing each row
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
