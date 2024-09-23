package com.muhsener98.github.activity.dto;



import com.muhsener98.json.annotation.JsonSubType;
import com.muhsener98.json.annotation.JsonSubTypes;

import java.util.Objects;

@JsonSubTypes(propertyName = "type" , value = {
        @JsonSubType(propertyValue = "CreateEvent" , clazz = "com.muhsener98.github.activity.dto.CreateEvent"),
        @JsonSubType(propertyValue =  "ForkEvent" , clazz = "com.muhsener98.github.activity.dto.ForkEvent"),
        @JsonSubType(propertyValue =  "IssuesEvent" , clazz = "com.muhsener98.github.activity.dto.IssuesEvent"),
        @JsonSubType(propertyValue = "PushEvent" , clazz = "com.muhsener98.github.activity.dto.PushEvent"),
        @JsonSubType(propertyValue = "WatchEvent" , clazz = "com.muhsener98.github.activity.dto.WatchEvent"),
        @JsonSubType(propertyValue = "ForkEvent" , clazz = "com.muhsener98.github.activity.dto.ForkEvent"),
        @JsonSubType(propertyValue = "CommitCommentEvent" , clazz = "com.muhsener98.github.activity.dto.CommitCommentEvent"),
        @JsonSubType(propertyValue = "DeleteEvent" , clazz = "com.muhsener98.github.activity.dto.DeleteEvent"),
        @JsonSubType(propertyValue = "GollumEvent" , clazz = "com.muhsener98.github.activity.dto.GollumEvent"),
        @JsonSubType(propertyValue = "IssueCommentEvent" , clazz = "com.muhsener98.github.activity.dto.IssueCommentEvent"),
        @JsonSubType(propertyValue = "MemberEvent" , clazz = "com.muhsener98.github.activity.dto.MemberEvent"),
        @JsonSubType(propertyValue = "PublicEvent" , clazz = "com.muhsener98.github.activity.dto.PublicEvent"),
        @JsonSubType(propertyValue = "PullRequestCommentReviewEvent" , clazz = "com.muhsener98.github.activity.dto.PullRequestCommentReviewEvent"),
        @JsonSubType(propertyValue = "PullRequestEvent" , clazz = "com.muhsener98.github.activity.dto.PullRequestEvent"),
        @JsonSubType(propertyValue = "PullRequestReviewEvent" , clazz = "com.muhsener98.github.activity.dto.PullRequestReviewEvent"),
        @JsonSubType(propertyValue = "PullRequestReviewThreadEvent" , clazz = "com.muhsener98.github.activity.dto.PullRequestReviewThreadEvent"),
        @JsonSubType(propertyValue = "ReleaseEvent" , clazz = "com.muhsener98.github.activity.dto.ReleaseEvent")

})
public abstract class GitHubEvent {

    protected String id ;
    protected String type ;
    protected GitHubRepo repo;



    public GitHubEvent() {
    }

    public GitHubEvent(String id, String type, GitHubRepo repo) {
        this.id = id;
        this.type = type;
        this.repo = repo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitHubEvent that = (GitHubEvent) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public GitHubRepo getRepo() {
        return repo;
    }
}
