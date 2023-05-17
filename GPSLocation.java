import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GPSLocation {
    private String locationData;

    public void getUserLocation() {
        try {
            // Get the IP address of the user
            URLConnection connection = new URL("https://api.ipify.org").openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String ipAddress = reader.readLine();
            reader.close();

            // Use IP Geolocation API to get location information
            URL geoUrl = new URL("https://ipapi.co/" + ipAddress + "/json/");
            URLConnection geoConnection = geoUrl.openConnection();
            BufferedReader geoReader = new BufferedReader(new InputStreamReader(geoConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String data;
            while ((data = geoReader.readLine()) != null) {
                response.append(data);
            }
            geoReader.close();

            locationData = response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUserLocationData() {
        return locationData;
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371; // Earth's radius in kilometers

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }

    // public static void main(String[] args) {
    //     GPSLocation gpsLocation = new GPSLocation();
    //     gpsLocation.getUserLocation();

    //     System.out.println("User's Location:");
    //     System.out.println(gpsLocation.getUserLocationData());

    //     // Coordinates of the nearby location (example: New York City)
    //     double nearbyLatitude = 40.7128;
    //     double nearbyLongitude = -74.0060;

    //     // Extract user's latitude and longitude from the location data
   
    //     double userLatitude = Double.parseDouble(locationParts[8].split(":")[1].trim());
    //     double userLongitude = Double.parseDouble(locationParts[9].split(":")[1].trim());

    //     // Calculate the distance between the user's location and the nearby location
    //     double distance = gpsLocation.calculateDistance(userLatitude, userLongitude, nearbyLatitude, nearbyLongitude);

    //     // Display the distance between the user's location and the nearby location
    //     System.out.println("Distance to the nearby location:");
    //     System.out.println(distance + " kilometers");
    // }
}
