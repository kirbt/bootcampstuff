package AccountDatabase;

public class AccountDatabase {
    
    // The AccountDatabase class should hold a list of Accounts and the current account logged into. The variables should all be static.



    /**
     * Checks whether or not the user is logged into an account.
     * @return true if current account is not null, false if otherwise.
     */
    public static boolean isLoggedIn() {
        return false;
    }
    /**
     * If the account database doesn't already have an account with that matches that username, create a new account with the
     * username and password inputted.
     * @param username username of new account
     * @param password password of new account
     * @return true if account successfully created, false if not.
     */
    public static boolean addNewAccount(String username, String password) {
        return false;
    }
    /**
     * Find the current account and delete it from the database.
     * Precondition: the current account is not null and the current account is not the admin account.
     * @return true if account successfully deleted, false if not.
     */
    public static boolean deleteAccount() {
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
    public static boolean logIn(String username, String password) {

        return false;
    }
    /**
     * Set the current account to null.
     * Precondition: the account is not already null.
     * @return true if logged out successfully, false if not already in an account.
     */
    public static boolean logOut() {
        return false;
    }
    /**
     * Prints the account information if logged in, prints a message about not being logged in if false.
     * Additionally, if the current account logged into is the admin account, print all of the information of
     * each account in the database.
     */
    public static void viewAccountInformation() {
    }
}
