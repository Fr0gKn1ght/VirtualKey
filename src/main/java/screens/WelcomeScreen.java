package screens;

import services.DirectoryService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import entities.File;
import services.ScreenService;

public class WelcomeScreen implements Screen {

    private String welcomeText = "Welcome to VirtualKey!";
    private String developerText = "Developer: Alex Schultz";

    private ArrayList<String> options = new ArrayList<>();
    private Scanner in;


    public WelcomeScreen(Scanner s) {
        options.add("1. Show Files");
        options.add("2. Show File Options Menu");
        options.add("3. Quit");
        
        in = s;
    }
    @Override
    public void Show()
    {
        System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("\n");
        
        for (String s : options)  {
            System.out.println(s);
        }

    }

    @Override
    public void GetUserInput()
    {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option)
    {
        switch(option) {

            case 1: // Show Files
                this.ShowFiles();
                break;
            case 2: // Show Submenu

                ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
                ScreenService.getCurrentScreen().Show();
                ScreenService.getCurrentScreen().GetUserInput();

                break;
            default:
                System.out.println("Invalid Option");
                break;

        }

    }

    public void ShowFiles() {
    	DirectoryService.sort();
        DirectoryService.PrintFiles();
    }

    private String getInputString()
    {
        return(in.nextLine());

    }
    private int getOption()
    {
        int returnOption = 0;
        try {
        	String iput = in.nextLine();
            returnOption = Integer.parseInt(iput);
        }
        catch (NumberFormatException ex) {
        	System.err.println("Input must be an int!");
        	return -1;
        }
        return returnOption;

    }
}