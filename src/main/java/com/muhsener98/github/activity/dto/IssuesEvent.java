package com.muhsener98.github.activity.dto;

import com.muhsener98.json.annotation.JsonProperty;

public class IssuesEvent extends GitHubEvent{

    @JsonProperty("payload.action")
    private  String payloadAction ;

    public IssuesEvent() {
    }

    public String getPayloadAction() {
        return payloadAction;
    }




}
