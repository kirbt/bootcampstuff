package KeyAccountDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        AccountDatabase database = new AccountDatabase();

        System.out.println("Welcome to the ACCOUNT DATABASE!\n");

        while (true) {
            System.out.println("\n Choose from the following actions you would like to do:");
            System.out.println("1 - Log in");
            System.out.println("2 - Log out");
            System.out.println("3 - Create new account");
            System.out.println("4 - Delete current account");
            System.out.println("5 - Display account information");
            System.out.println("6 - Exit ACCOUNT DATABASE\n");

            System.out.println("Please input a number corresponding to the actions above.\n");

            String action = scan.nextLine();

            if (action.equals("1")) {
                System.out.println("\nInput username: ");
                String username = scan.nextLine();
                System.out.println("input password: ");
                String password = scan.nextLine();

                if (database.logIn(username, password)) {
                    System.out.println("\nLogged into " + username);
                }
                else {
                    System.out.println("\nLog in was insuccessful, we couldn't find a match based off the username and password inputted");
                }

            }
            else if (action.equals("2")) {
                if (database.isLoggedIn()) {
                    database.logOut();
                    System.out.println("\nLog out successful!");
                }
                else {
                    System.out.println("\nlog out insuccesful: No account to log out of");
                }
            }
            else if (action.equals("3")) {
                System.out.println("\nCREATE ACCOUNT: ");
                System.out.println("\nInput username: ");
                String username = scan.nextLine();
                System.out.println("input password: ");
                String password = scan.nextLine();

                if (database.addNewAccount(username, password)) {
                    System.out.println("Account " + username + " is has been registered into the database!");
                }
                else {
                    System.out.println("The database couldn't add your new account. Username already matches an account in the system.");
                }
            }
            else if (action.equals("4")) {
                if (database.deleteAccount()) {
                    System.out.println("\nAccount successfully deleted!");
                }
                else {
                    System.out.println("\nAccount unsuccessfully deleted. Need to be currently logged into an account.");
                }
            }
            else if (action.equals("5")) {
                database.viewAccountInformation();
            }
            else if (action.equals("6")) {
                System.out.println("\nExiting ACCOUNT DATABASE");
                System.out.println("Thank you for using ACCOUNT DATABASE!\n");
                break;
            }
            else {
                System.out.println("Invalid Action");
            }

            System.out.println("\nPress enter to continue");
                scan.nextLine();
        }

        scan.close();
    }
}
