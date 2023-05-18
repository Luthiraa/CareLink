
/**
 * Main
 */
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean run = true;
        Scanner scan = new Scanner(System.in);
        HospitalLocator hLocator = new HospitalLocator();
        hLocator.readCoords();
        // while (run) {
            GPSLocation gpsLocation = new GPSLocation();
            gpsLocation.getUserLocation();
            hLocator.readCoords();
    //         System.out.println("User's Location:");
    //         System.out.println(gpsLocation.getUserLocationData());
    //         String[] locationParts = gpsLocation.getUserLocationData().split(",");
    //         double nearbyLatitude = 40.7128;
    //         double nearbyLongitude = -74.0060;

    //         double userLatitude = Double.parseDouble(locationParts[15].split(":")[1].trim());
    //         double userLongitude = Double.parseDouble(
    //                 locationParts[16].split(":")[1].trim());
    //         System.out.println(userLatitude);
    //         System.out.println(userLongitude);

    //         // Calculate the distance between the user's location and the nearby location
    //         double distance = gpsLocation.calculateDistance(userLatitude, userLongitude, nearbyLatitude, nearbyLongitude);
    //         // Display the distance between the user's location and the nearby location
    //         System.out.println("Distance to the nearby location:");
    //         System.out.println(distance + " kilometers");

    //         snakeText(
    //                 "",
    //                 1);
    //         Thread.sleep(100);
    //         clearScreen();
    //         System.out.println("");
    //         String mainMenu = "*************************************************\n" +
    //                 "* Main Menu *\n" +
    //                 "* *\n" +
    //                 "* 1) Shelter Locator *\n" +
    //                 "* 2) Hospital Locator *\n" +
    //                 "* 3) Food Bank Locator *\n" +
    //                 "* 4) My Health *\n" +
    //                 "* 5) Exit *\n" +
    //                 "* *\n" +
    //                 "* Enter choice: *\n" +
    //                 "* *\n" +
    //                 "*************************************************";
    //         snakeText(mainMenu, 10);
    //         int choice = scan.nextInt();
    //         switch (choice) {
    //             case 1:

    //                 break;
    //             case 2:
    //                 break;
    //             case 3:

    //                 break;
    //             case 4:
    //                 break;
    //             case 5:
    //                 break;
    //         }
    //     }
    // }

    // public static void snakeText(String text, int interval) {
    //     int i;
    //     // for loop used to print each characater after a 0.005 second delay.
    //     for (i = 0; i < text.length(); i++) {
    //         // prints a formatted string
    //         System.out.printf("%c", text.charAt(i));
    //         // Try and catch function used to catch exceptions that might occur
    //         try {
    //             Thread.sleep(interval);
    //         } catch (InterruptedException ex) {
    //             Thread.currentThread().interrupt();
    //         }
    //     }
    // }

    // public static void clearScreen() {

    //     System.out.print("\033[H\033[2J");
    //     System.out.flush();

    // }
}
}