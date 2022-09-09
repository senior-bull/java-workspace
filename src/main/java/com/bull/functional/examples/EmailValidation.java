package com.bull.functional.examples;

import java.util.function.Function;
import java.util.regex.Pattern;

import static com.bull.functional.examples.Case.match;
import static com.bull.functional.examples.Case.mcase;

public class EmailValidation {

    static Pattern emailPattern =
        Pattern.compile("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static Function<String, Result<String>> emailChecker = s -> match(
        mcase(() -> Result.success(s)),
        mcase(() -> s == null, () -> Result.failure("email must not be null")),
        mcase(() -> s.length() == 0, () -> Result.failure("email must not be empty")),
        mcase(() -> !emailPattern.matcher(s).matches(), () -> Result.failure("email " + s + " is invalid."))
    );

    public static void main(String... args) {
        emailChecker.apply("this.is@my.email").bind(success, failure);
        emailChecker.apply(null).bind(success, failure);
        emailChecker.apply("").bind(success, failure);
        emailChecker.apply("john.doe@acme.com").bind(success, failure);
    }

    static Effect<String> success = s -> System.out.println("Mail sent to " + s);
    static Effect<String> failure = s -> System.err.println("Error message logged: " + s);
}
