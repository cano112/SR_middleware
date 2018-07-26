package pl.edu.agh.wiet.sr.banking.bank.account;

import pl.edu.agh.wiet.sr.banking.generated.services.PermissionDeniedException;

public class AuthUtils {

    public static void checkPassword(String passwordOne, String passwordTwo)
            throws PermissionDeniedException {
        if(!passwordOne.equals(passwordTwo))
            throw new PermissionDeniedException("Incorrect password");
    }
}
