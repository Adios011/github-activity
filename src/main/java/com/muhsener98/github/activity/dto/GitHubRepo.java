package com.muhsener98.github.activity.dto;

public class GitHubRepo {

    private String name ;


    @Override
    public String toString() {
        return "GitHubRepo{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
