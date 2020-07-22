package by.home.courseback.exeption;

public class AccountResourceException extends RuntimeException {

    public AccountResourceException() {
        super("No user was found for this activation key");
    }
}
