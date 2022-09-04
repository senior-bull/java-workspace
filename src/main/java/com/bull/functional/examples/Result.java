package com.bull.functional.examples;

public interface Result {
    public class Success implements Result {}
    public class Failure implements Result {
        private final String errorMessage;
        public Failure(String s) {
            this.errorMessage = s;
        }
        public String getMessage() {
            return errorMessage;
        }
    }
}
