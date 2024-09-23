package com.muhsener98.github.activity.dto;

public class WatchEvent  extends GitHubEvent{


    public WatchEvent() {
    }

    public WatchEvent(String id, String type, GitHubRepo repo) {
        super(id, type, repo);
    }
}
