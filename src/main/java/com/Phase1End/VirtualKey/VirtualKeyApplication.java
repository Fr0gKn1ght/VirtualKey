package com.Phase1End.VirtualKey;

import entities.*;
import screens.WelcomeScreen;
import services.DirectoryService;
import services.ScreenService;

import java.util.Optional;

public class VirtualKeyApplication {


    public static String Greeting() {
        return("Hello World!");
    }

    public static void main(String[] args) {


        DirectoryService.AddTestData();
        DirectoryService.PrintFiles();
        ScreenService.getCurrentScreen().Show();
        ScreenService.getCurrentScreen().GetUserInput();
        
        ScreenService.end();

    }
}
