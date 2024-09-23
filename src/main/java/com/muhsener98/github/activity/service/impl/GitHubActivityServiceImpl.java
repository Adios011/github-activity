package com.muhsener98.github.activity.service.impl;


import com.muhsener98.github.activity.dto.GitHubEvent;


import com.muhsener98.github.activity.exception.NoSuchUserException;

import com.muhsener98.github.activity.service.GitHubActivityService;
import com.muhsener98.github.activity.service.GitHubRestClient;
import com.muhsener98.json.CustomCollectionType;


import com.muhsener98.json.parser.JsonMapper2;


import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GitHubActivityServiceImpl implements GitHubActivityService {

    private final GitHubRestClient gitHubRestClient;


    public GitHubActivityServiceImpl(GitHubRestClient gitHubRestClient) {
        this.gitHubRestClient = gitHubRestClient;

    }


    @Override
    public List<GitHubEvent> fetchGitHubActivitiesOf(String username) throws NoSuchUserException {
        HttpResponse<String> response = gitHubRestClient.fetchEventsOf(username);

        if (response.statusCode() == 404) {
            throw new NoSuchUserException(username);
        } else if (response.statusCode() == 200) {
//            System.out.println(response.body());

            JsonMapper2 jsonMapper = new JsonMapper2();
            return jsonMapper.readValue(response.body(), new CustomCollectionType(List.class, GitHubEvent.class));

        } else {
            return null;
        }


    }


}
