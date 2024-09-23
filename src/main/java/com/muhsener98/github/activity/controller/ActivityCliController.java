package com.muhsener98.github.activity.controller;

import com.muhsener98.github.activity.dto.GitHubEvent;
import com.muhsener98.github.activity.exception.NoSuchUserException;
import com.muhsener98.github.activity.service.GitHubActivityService;

import java.util.List;

public class ActivityCliController {

    private final GitHubActivityService gitHubActivityService;

    public ActivityCliController(GitHubActivityService gitHubActivityService) {
        this.gitHubActivityService = gitHubActivityService;
    }

    public List<GitHubEvent> getAllEventsOf(String username){
        List<GitHubEvent> events = null;
        try {
            events = gitHubActivityService.fetchGitHubActivitiesOf(username);
        } catch (NoSuchUserException e) {
            System.err.println("No such user found: "+ username);
        }catch (Exception exception){
            System.err.println("unknown internal error");
        }

        return events;
    }
}
