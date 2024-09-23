package com.muhsener98.github.activity;

import com.muhsener98.github.activity.dto.*;

import java.util.List;

public class OutputGenerator {


    public void printOutput(List<GitHubEvent> events) {
        System.out.println("Output:");
        for (GitHubEvent event : events) {
            if (event instanceof CreateEvent createEvent) {
                System.out.println(String.format(" - Created %s in %s", createEvent.getPayloadRefType(), createEvent.getRepo().getName()));
            } else if (event instanceof PushEvent pushEvent) {
                System.out.println(String.format(" - Pushed %d commits(s) to %s", pushEvent.getCommits().length, pushEvent.getRepo().getName()));
            } else if (event instanceof IssuesEvent issuesEvent) {
                System.out.println(String.format(" - %s an issue in %s", capitalizeFirstLetter(issuesEvent.getPayloadAction()),
                        issuesEvent.getRepo().getName()));
            }else if(event instanceof WatchEvent watchEvent){
                System.out.println(String.format(" - Starred %s", watchEvent.getRepo().getName()));
            }else if(event instanceof ForkEvent forkEvent){
                System.out.println(String.format(" - Forked %s" , forkEvent.getRepo().getName()));
            }else
                System.out.println(String.format(" - %s in %s" , event.getType().replace("Event" , "") , event.getRepo().getName()));
        }
    }

    private String capitalizeFirstLetter(String str) {
        return str.substring(0, 1).toUpperCase().concat(str.substring(1));
    }
}
