package com.muhsener98.github.activity.dto;

import com.muhsener98.json.annotation.JsonProperty;

public class PushEvent extends GitHubEvent{

    @JsonProperty("payload.commits")
    private  Commit[] commits ;



    public PushEvent() {
    }


    public Commit[] getCommits() {
        return commits;
    }
}
