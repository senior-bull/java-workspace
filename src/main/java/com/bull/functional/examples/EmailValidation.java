package com.bull.functional.examples;

import java.util.function.Function;
import java.util.regex.Pattern;

public class EmailValidation {

    static Pattern emailPattern =
        Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static Function<String, Result> emailChecker = s ->
        s == null
            ? new Result.Failure("email must not be null")
            : s.length() == 0
                ? new Result.Failure("email must not be empty")
                : emailPattern.matcher(s).matches()
                    ? new Result.Success()
                    : new Result.Failure("email " + s + " is invalid.");

    public static void main(String... args) {
        validate("this.is@my.email");
        validate(null);
        validate("");
        validate("john.doe@acme.com");
    }
    private static void logError(String s) {
        System.err.println("Error message logged: " + s);
    }
    private static void sendVerificationMail(String s) {
        System.out.println("Mail sent to " + s);
    }
    static Executable validate(String s) {
        Result result = emailChecker.apply(s);
        return (result instanceof Result.Success)
            ? () -> sendVerificationMail(s)
            : () -> logError(((Result.Failure) result).getMessage());
    }
}
