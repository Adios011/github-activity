package com.muhsener98.github.activity.service;

import com.muhsener98.github.activity.dto.GitHubEvent;
import com.muhsener98.github.activity.exception.NoSuchUserException;

import java.util.List;

public interface GitHubActivityService {

    List<GitHubEvent> fetchGitHubActivitiesOf(String username) throws NoSuchUserException;
}
