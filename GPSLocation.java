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

    /**
     * Calculates the distance between two points on the Earth's surface using the
     * Haversine formula [haversine(theta) = sin^2 (theta/2)]
     * 
     * @param lat1 The latitude of the first point in degrees.
     * @param lon1 The longitude of the first point in degrees.
     * @param lat2 The latitude of the second point in degrees.
     * @param lon2 The longitude of the second point in degrees.
     * @return The distance between the two points in kilometers.
     */
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
}
