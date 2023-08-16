package KeyAccountDatabase;

public class Account {
    
    // the Account class should have variables for the username, password, and login attempts.
    private String username;
    private String password;
    private int logInAttempts;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.logInAttempts = 0;
    }



    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getLogInAttempts() {
        return logInAttempts;
    }
    public void addLogInAttempt() {
        logInAttempts += 1;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
