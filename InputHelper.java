import java.util.Scanner;

public class InputHelper {
    private InputHelper() {
        // This class only contains input utilities.
    }

    public static String readLine(Scanner scanner) {
        return scanner.hasNextLine() ? scanner.nextLine() : "";
    }

    public static int readChoice(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a number.");
            }
        }

        return 0;
    }
}
