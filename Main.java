
/**
 * System.out.println(G.A.J);
 * @author Luthira Abeykoon, Ethan Ieong,                                                                                               Rain Zhao
 * @version 2.0
 * @since May 13th 2023
 */
//import libraries
import java.util.*;

//main claaa
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in); // create scanner object
        boolean run = true; // set boolean run variable to true
        while (run) {
            snakeText(menu(), 2); // call snaketext method to print menu function with a interval of 2
                                  // milliseconds
            int choice = scan.nextInt(); // gets choice from user
            switch (choice) { // switch statements
                case 1: // first case
                    HospitalLocator hLocator = new HospitalLocator(); // instance of HospitalLocator class for locating hospital 
                    hLocator.readCoords(); // calls readcoords method in the hospitallocator class
                case 2: // second case
                    foodBank fLocator = new foodBank(); // instance of foodbank clas for locating foodbanks
                    fLocator.readCoords(); // calls readcoords method in foodbank class
                    break; //break
                case 3: // third case
                    healthStats stats = new healthStats(); // instance of healthstats class
                    stats.healthStat(); // calls hehalthstat method in healthstats class
                case 4: // forth case
                    snakeText("Press enter to continue", 2); // calls staketext method to print continue
                    scan.nextLine();
                    clearScreen(); // clear the screen
                    snakeText("Program closed.", 20); // prints program closed
                    run = false; // closes program
                    break;  //break

            }
        }
        scan.close();  //close scanner
    }

    /**
     * 
     * Prints each character of the given text in a "snake" effect with a specified
     * interval between characters.
     * 
     * @param text     The text to be printed in a snake effect.
     * 
     * @param interval The interval (in milliseconds) between printing each
     *                 character.
     */

    public static void snakeText(String text, int interval) {
        int i;
        // for loop used to print each characater after a 0.005 second delay.
        for (i = 0; i < text.length(); i++) {
            // prints a formatted string
            System.out.printf("%c", text.charAt(i));
            // Try and catch function used to catch exceptions that might occur
            try {
                Thread.sleep(interval);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * 
     * Prints each character of the given text in a "snake" effect with a slight
     * delay between characters.
     * 
     * @param text The text to be printed in a snake effect.
     */
    public static void snakeText(String text) {
        int i;
        // for loop used to print each characater after a 0.005 second delay.
        for (i = 0; i < text.length(); i++) {
            // prints a formatted string
            System.out.printf("%c", text.charAt(i));
            // Try and catch function used to catch exceptions that might occur
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * 
     * Clears the console screen by printing escape sequences.
     */

    public static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * 
     * Displays the main menu and returns it as a string.
     * 
     * The menu includes options for Hospital Locator, Food Bank Locator, My Health,
     * and Exit.
     * 
     * @return The main menu as a string.
     */
    public static String menu() {
        clearScreen();
        String mainMenu = "*************************************************\n" +
                "*                  Main Menu                    *\n" +
                "*                                               *\n" +
                "* 1) Hospital Locator                           *\n" +
                "* 2) Food Bank Locator                          *\n" +
                "* 3) My Health                                  *\n" +
                "* 4) Exit                                       *\n" +
                "*                                               *\n" +
                "* Enter choice:                                 *\n" +
                "*                                               *\n" +
                "*************************************************\n";
        return mainMenu;
    }
}
