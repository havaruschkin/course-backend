package by.home.courseback.exeption;

public class EmailAlreadyUsedException extends RuntimeException {

    public EmailAlreadyUsedException() {
        super("Email name already used!");
    }
}
