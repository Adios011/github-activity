package com.muhsener98.github.activity.exception;

public class NoSuchUserException extends Exception{

    public NoSuchUserException(String username) {
        super("No such user found: " + username);
    }
}
