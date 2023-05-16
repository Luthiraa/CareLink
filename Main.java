/**
 * Main
 */

public class Main {

    public static void main(String[] args) throws Exception {
        boolean run = true;

        while (run) {

            snakeText(
                    "Welcome to the Homeless Resource App!\n\nWe understand that navigating the challenges of homelessness can be incredibly difficult. This app is designed to provide you with essential resources and support to help improve your situation and access the assistance you need.\n\nOur goal is to empower you by connecting you with a wide range of services and information that can make a positive impact on your life. Whether you're seeking shelter, food, healthcare, job opportunities, or other essential resources, this app is here to guide you every step of the way.\n\nExplore the app to discover a comprehensive directory of local shelters, food banks, healthcare facilities, employment services, and community organizations dedicated to assisting those experiencing homelessness. Additionally, you'll find helpful articles, tips, and advice on topics such as finding housing, improving your financial situation, and accessing social support networks.\n\nWe believe that everyone deserves a safe and stable living environment, and we're committed to helping you on your journey towards stability. Remember, you are not alone – there are resources available and people ready to support you.\n\nWe hope this app serves as a valuable tool on your path towards regaining independence and improving your quality of life. If you have any questions or need assistance, please don't hesitate to reach out to our dedicated team.\n\nTogether, let's build a brighter future.\n\nThe Homeless Resource App Team",1);
            Thread.sleep(100);
            clearScreen();
            System.out.println("");
        }
    }

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

    public static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}