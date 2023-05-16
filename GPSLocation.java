import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GPSLocation {
    public static void main(String[] args) {
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
            String locationData;
            StringBuilder response = new StringBuilder();
            while ((locationData = geoReader.readLine()) != null) {
                response.append(locationData);
            }
            geoReader.close();

            // Parse and display the location information
            System.out.println("User's Location:");
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
