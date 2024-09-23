package com.muhsener98;

import com.muhsener98.github.activity.OutputGenerator;
import com.muhsener98.github.activity.controller.ActivityCliController;
import com.muhsener98.github.activity.dto.GitHubEvent;
import com.muhsener98.github.activity.service.GitHubActivityService;
import com.muhsener98.github.activity.service.GitHubRestClient;
import com.muhsener98.github.activity.service.impl.GitHubActivityServiceImpl;

import java.util.Arrays;
import java.util.List;


public class App {
    public static void main(String[] args) {
        System.out.println("Application has started with arguments: " + Arrays.toString(args));

        if(args.length == 0 || args[0].isEmpty()){
            System.err.println("Usage : github-activity <username>" );
            System.exit(0);
        }

        GitHubRestClient gitHubRestClient = new GitHubRestClient();
        GitHubActivityService gitHubActivityService = new GitHubActivityServiceImpl(gitHubRestClient);
        ActivityCliController cliController = new ActivityCliController(gitHubActivityService);
        OutputGenerator outputGenerator = new OutputGenerator();



        List<GitHubEvent> gitHubEventList = cliController.getAllEventsOf(args[0]);
        outputGenerator.printOutput(gitHubEventList);




    }
}
