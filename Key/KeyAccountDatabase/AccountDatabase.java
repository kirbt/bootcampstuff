package KeyAccountDatabase;

import java.util.ArrayList;

public class AccountDatabase {
    
    // The AccountDatabase class should hold a list of Accounts and the current account logged into. The variables should all be static. The variable for the database should by default, contain an account with the username "admin" and the password "password"
    private ArrayList<Account> database;
    private Account currentAccount;

    public AccountDatabase() {
        database = new ArrayList<Account>();
        database.add(new Account("admin", "password"));
    }

    /**
     * Checks whether or not the user is logged into an account.
     * @return true if current account is not null, false if otherwise.
     */
    public boolean isLoggedIn() {
        return (currentAccount != null);
    }
    /**
     * If the account database doesn't already have an account with that matches that username, create a new account with the
     * username and password inputted.
     * @param username username of new account
     * @param password password of new account
     * @return true if account successfully created, false if not.
     */
    public boolean addNewAccount(String username, String password) {
        for (Account account : database) {
            if (username.equals(account.getUsername())) {
                
                return false;
            }
        }
        database.add(new Account(username, password));
        return true;
    }
    /**
     * Find the current account and delete it from the database.
     * Precondition: the current account is not null and the current account is not the admin account.
     * @return true if account successfully deleted, false if not.
     */
    public boolean deleteAccount() {
        if (isLoggedIn() && !currentAccount.getUsername().equals("admin")) {
            database.remove(currentAccount);
            currentAccount = null;
            return true;
        }
        return false;
    }

    /**
     * Use the username and password parameters to search the Account Database for an account that matches the inputted
     * information. If theres an account with a matching username, add to the account's log in attempts and check the password.
     * If the password also matches, set the current account of the database to said account.
     * @param username account to log into
     * @param password password to log in
     * @return true if logged in successfully, false if not.
     */
    public boolean logIn(String username, String password) {

        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getUsername().equals(username)) {
                database.get(i).addLogInAttempt();
                if (database.get(i).getPassword().equals(password)) {
                    currentAccount = database.get(i);
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Set the current account to null.
     * Precondition: the account is not already null.
     * @return true if logged out successfully, false if not already in an account.
     */
    public boolean logOut() {
       if (currentAccount == null) {
        return false;
       }
       currentAccount = null;
       return true;
    }
    /**
     * Prints the account information if logged in, prints a message about not being logged in if false.
     * Additionally, if the current account logged into is the admin account, print all of the information of
     * each account in the database.
     */
    public void viewAccountInformation() {

        if (currentAccount == null) {
                System.out.println("\nNot logged into an account.");
        }
        else if (currentAccount.getUsername().equals("admin")) {

            System.out.println("\n ~~ DATABASE ACCOUNTS ~~");

            for (Account account : database) {

                System.out.println("\nUsername: " + account.getUsername());
                System.out.println("Password: " + account.getPassword());
                System.out.println("Login attempts: " + account.getLogInAttempts());
            }
        }
        else {
            System.out.println("\n ~~ ACCOUNT INFORMATION ~~");

            System.out.println("\nUsername: " + currentAccount.getUsername());
            System.out.println("Password: " + currentAccount.getPassword());
            System.out.println("Login attempts: " + currentAccount.getLogInAttempts());
        }
    }
}
