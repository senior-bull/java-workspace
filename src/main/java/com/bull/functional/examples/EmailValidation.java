package com.bull.functional.examples;

import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidation {

    final Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
    final Function<String, Boolean> emailChecker = s -> emailPattern.matcher(s).matches();

    void testMail(String email) {
        if (emailChecker.apply(email)) {
            sendVerificationMail(email);
        } else {
            logError("email " + email + " is invalid.");
        }
    }

    void sendVerificationMail(String s) {
        System.out.println("Verification mail sent to " + s);
    }

    private static void logError(String s) {
        System.err.println("Error message logged: " + s);
    }

    public static void main(String[] args) {
        EmailValidation t = new EmailValidation();
        t.testMail("john.doe@acme.com");
        t.testMail(null);
        t.testMail("paul.smith@acme.com");
    }
}
