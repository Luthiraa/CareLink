// Import all necessary libraries
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * The HospitalLocator class is responsible for reading hospital coordinates from a CSV file
 * and finding nearby hospitals based on user location.
 */
public class HospitalLocator {
    
    /**
     * Reads hospital coordinates from a CSV file and finds nearby hospitals based on user location.
     */
    public void readCoords() {
        String csvFile = "CSVfiles/hospital.csv"; // Path to the CSV file containing hospital data
        String delimiter = ","; // CSV delimiter
        GPSLocation gpsLocation = new GPSLocation(); // Instance of GPSLocation class for handling GPS data
        myHealth health = new myHealth(csvFile, 0, delimiter); // Instance of myHealth class for health-related functionality
        String[][] nearbyHospitals = new String[3][2]; // Array to store nearby hospitals and their distances
        
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;

            while ((line = reader.readLine()) != null) { // loop to keep reading until there are no more line/rows left in the csv file.
                String[] columns = line.split(delimiter); // use the delimiter to slip the row into columns and store it as a string
                if (columns.length >= 2) { 
                    String latitude = columns[1]; // latitude is referenced as a string from the 2nd column
                    double dlat = Double.parseDouble(latitude); //dlat is the latitude obtained from the array but is casted to a double
                    String longitude = columns[2]; // longititude is refernced as a string from the 3rd column 
                    double dlong = Double.parseDouble(longitude); //dlong is the longitude (which used to be a string) now casted to a double
                    String hName = columns[0]; // the name of the hostipal (hName) is referenced from teh first column and stores as a string
                    gpsLocation.getUserLocation(); //create an instance of the gpslocation class and create an instance
                    String[] locationParts = gpsLocation.getUserLocationData().split(","); //split the location arts previously obtained from the gpsLocation class and split each element using the "," delimiter
                    double userLatitude = Double.parseDouble(locationParts[15].split(":")[1].trim()); //get the user's laitude from the 15th index of the location parts string/array and get rid of any empty spaces
                    double userLongitude = Double.parseDouble(locationParts[16].split(":")[1].trim()); //get the user's longititude from the 16th index of the locatiom parts string/array and get rid of any empty spaces
                    double distance = gpsLocation.calculateDistance(userLatitude, userLongitude, dlat, dlong); //calculate the distance by passing the user's 
                    if (distance < 10) { // if the distance is less than 10
                        nearbyHospitals[0][0] = hName; // the first column of nearbyHospital will store the name of the hospital
                        nearbyHospitals[0][1] = String.valueOf(distance); // the second column of nearbyHospital will store the distance form the user's lcoation
                    }else{
                        System.out.println("There are no hospitals to be found within a 10km radius of your location.");
                    }
                }
            }
            
            // Print the location and distance of the nearest hospital
            System.out.println("Location: " + nearbyHospitals[0][0] + " Location(km): "
                    + Math.round(Double.parseDouble(nearbyHospitals[0][1]) * 100.0) / 100.0);
            
            // Move to the next line after printing each row
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
