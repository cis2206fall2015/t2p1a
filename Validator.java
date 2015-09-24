//package t2p1a;

import java.util.Scanner;

/**
 * Prompts for and then validates console based input.
 * Based in part on code from Murach's Java SE 6 by Joel Murach, et. al.
 *
 * @author Marshall Ehlinger
 * @author Jon VanZile
 * @author John Phillips
 */
public class Validator {

    /**
     * Prompts the user with a message and then retrieves what the user types as
     * a String.
     *
     * @param sc		The user input
     * @param prompt		String providing context for the user before input is entered
     */
    public static String getLine(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    /**
     * Prompts the user with a message and then retrieves what the user types as
     * a String. The regex is a String that contains a regular expression. The
     * message repeats until the user enters a correct value. For example, a
     * regular expression of "^[qadl]$" would require a "q" or an "a" or a "d"
     * or an "l" to be entered. A regular expression of "^quit|add|delete|list$"
     * would require one of the listed words to be entered. A regular expression
     * of "^\d\d-\d\d-\d\d\d\d$" would require a date in the form of
     * "11-01-2014" to be entered.
     *
     * @param sc		The user input	
     * @param prompt		String providing context for the user before input is entered
     * @param regex		A regular expression for comparing entered values against a designated format
     * @return			returns String s, the contents of which change based on outcome of if statement		
     */
    public static String getLine(Scanner sc, String prompt, String regex) {
        boolean isValid = false;
        String s = "";
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextLine()) {
                s = sc.nextLine();
                if (s.matches(regex)) {
                    isValid = true;
                } else {
                    System.out.println("\nError! Invalid value. Try again.\n");
                }
            }
        }
        return s;
    }

    /**
     * Prompts the user with a message and then retrieves the user input as
     * an integer.
     *
     * @param sc		user input
     * @param prompt		String providing context to user for desired input
     * @return			Returns an integer "i", if sc was found to be valid, the "i" will be returned, containing the contents of sc
     */
    public static int getInt(Scanner sc, String prompt) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid integer value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }

    /**
     *Prompts the user for input and retrives input as an integer, then compares user input against a minimum and maximum value
     *
     * @param sc		User input, stored as an integer
     * @param prompt		String providing context to the user before input is entered
     * @param min		Lower value that user input is compared against, if input is lower than "min" an  error is generated
     * @param max		Upper value that user input is compared against, if input is greater than "max" an error is generated
     * @return			So long as user input is within "min" and "max" integers, "i" is returned, containing the user input integer
     */
    public static int getInt(Scanner sc, String prompt, int min, int max) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            i = getInt(sc, prompt);
            if (i < min) {
                System.out.println("\nError! Must be greater than or equal to " + min);
            } else if (i > max) {
                System.out.println("\nError! Must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }

    /**
     * Prompts the user with a message and then retrieves what the user types as
     * an integer.
     *
     * @param sc
     * @param prompt
     * @return
     */
    public static long getLong(Scanner sc, String prompt) {
        boolean isValid = false;
        long i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextLong()) {
                i = sc.nextLong();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid long value. Try again.");
            }
            sc.nextLine();
        }
        return i;
    }
 /**
     *Prompts the user for input and retrives input as a long integer, then compares user input against a minimum and maximum value
     *
     * @param sc		User input, stored as an integer
     * @param prompt		String providing context to the user before input is entered
     * @param min		Lower value that user input is compared against, if input is lower than "min" an  error is generated
     * @param max		Upper value that user input is compared against, if input is greater than "max" an error is generated
     * @return			So long as user input is within "min" and "max" long integers, "i" is returned, containing the user input 
     *				long iteger
     */
    public static long getLong(Scanner sc, String prompt, long min, long max) {
        boolean isValid = false;
        long i = 0;
        while (isValid == false) {
            i = getLong(sc, prompt);
            if (i < min) {
                System.out.println("\nError! Must be greater than or equal to " + min);
            } else if (i > max) {
                System.out.println("\nError! Must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }
    /**
     *Prompts the user for input and retrives input as a double, then compares user input against a minimum and maximum value
     *
     * @param sc		User input
     * @param prompt		String providing context to the user before input is entered
     * @return			Returns variable d of data type double, containing user input (if found to be valid). Otherwise d contains "0"
     */ 
    public static double getDouble(Scanner sc, String prompt) {
        boolean isValid = false;
        double d = 0;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid double value. Try again.");
            }
            sc.nextLine();
        }
        return d;
    }
    
    /**
     *Prompts the user for input and retrives input as a double, then compares user input against a minimum and maximum value
     *
     * @param sc		User input, stored as a double if found to be valid
     * @param prompt		String providing context to the user before input is entered
     * @param min		Lower value that user input is compared against, if input is lower than "min" an  error is generated
     * @param max		Upper value that user input is compared against, if input is greater than "max" an error is generated
     * @return			So long as user input is within "min" and "max", variable d is returned, containing the user input double
     */ 
    public static double getDouble(Scanner sc, String prompt, double min,
            double max) {
        boolean isValid = false;
        double d = 0;
        while (isValid == false) {
            d = getDouble(sc, prompt);
            if (d < min) {
                System.out.println("\nError! Must be greater than or equal to " + min);
            } else if (d > max) {
                System.out.println("\nError! Must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return d;
    }
}
