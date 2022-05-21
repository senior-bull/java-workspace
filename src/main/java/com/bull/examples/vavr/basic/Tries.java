package com.bull.examples.vavr.basic;

import io.vavr.control.Try;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class Tries {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    private static Try<LocalDate> parseDate(String dateString){
        return Try.of(() -> LocalDate.from(formatter.parse(dateString)));
    }

    public static void main(String args[]) {
        Stream.of("12/31/2014", "01-01-2015", "12/31/2015", "not a date", "01/01/2016")
                .map(Tries::parseDate)
                .peek(v-> v.onFailure(t -> System.out.println("Failed due to " + t.getMessage())))
                .filter(Try::isSuccess)
                .map(Try::get)
                .map(DayOfWeek::from)
                .forEach(System.out::println);
    }
}
