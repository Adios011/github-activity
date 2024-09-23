package com.muhsener98.github.activity.dto;

import com.muhsener98.json.annotation.JsonProperty;

public class CreateEvent extends GitHubEvent{

    @JsonProperty("payload.ref_type")
    private  String payloadRefType;


    public CreateEvent(){

    }

    public CreateEvent(String id, String type, GitHubRepo repo, String payloadRefType) {
        super(id, type, repo);
        this.payloadRefType = payloadRefType;
    }

    public String getPayloadRefType() {
        return payloadRefType;
    }


    @Override
    public String toString() {
        return "CreateEvent{" +
                "payloadRefType='" + payloadRefType + '\'' +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", repo=" + repo +
                '}';
    }
}
